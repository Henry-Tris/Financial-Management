package application;

import java.time.LocalDate;
import java.util.Scanner;

import entities.Bills;
import entities.Category;
import entities.Client;
import entities.Deal;
import entities.Product;
import entities.sellOnCredit;
import enumEntities.BudgetBucket;
import enumEntities.ExpenseContext;
import enumEntities.PaymentStatus;
import enumEntities.TypeStatus;
import services.CashFlow;
import services.ServiceReport;
import services.Stock;

public class Program {

    private static Scanner scanner = new Scanner(System.in);
    private static Stock stock = new Stock();
    private static CashFlow cashFlow = new CashFlow();
    private static ServiceReport report = new ServiceReport(cashFlow, stock);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addProduct();
            } else if (choice == 2) {
                addDeal();
            } else if (choice == 3) {
                addSellOnCredit();
            } else if (choice == 4) {
                addBill();
            } else if (choice == 5) {
                System.out.println(report.generateSummary());
            } else if (choice == 6) {
                System.out.println("Capital de giro: R$ " + String.format("%.2f", report.workingCapital()));
            } else if (choice == 7) {
                System.out.println(report.budgetSummary());
            } else if (choice == 0) {
                running = false;
                System.out.println("Encerrando o sistema...");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== Controle Financeiro ===");
        System.out.println("1 - Adicionar produto ao estoque");
        System.out.println("2 - Registrar receita/despesa");
        System.out.println("3 - Registrar venda fiado");
        System.out.println("4 - Adicionar conta a pagar");
        System.out.println("5 - Ver resumo financeiro");
        System.out.println("6 - Ver capital de giro");
        System.out.println("7 - Ver método 50/30/20");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void addProduct() {
        System.out.print("Nome do produto: ");
        String name = scanner.nextLine();

        System.out.print("Preço de custo: ");
        double costPrice = scanner.nextDouble();

        System.out.print("Preço de venda: ");
        double salePrice = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        stock.addProduct(new Product(name, costPrice, salePrice, quantity));
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void addDeal() {
        System.out.print("Nome da movimentação: ");
        String name = scanner.nextLine();

        System.out.print("Valor: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tipo (1 - Receita, 2 - Despesa): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();
        TypeStatus type = (typeChoice == 1) ? TypeStatus.RECEITA : TypeStatus.DESPESA;

        System.out.print("Nome da categoria: ");
        String categoryName = scanner.nextLine();

        System.out.print("Balde do orçamento (1 - Necessidade, 2 - Desejo, 3 - Poupança): ");
        int bucketChoice = scanner.nextInt();
        scanner.nextLine();

        BudgetBucket bucket;
        if (bucketChoice == 2) {
            bucket = BudgetBucket.DESEJO;
        } else if (bucketChoice == 3) {
            bucket = BudgetBucket.POUPANCA;
        } else {
            bucket = BudgetBucket.NECESSIDADE;
        }
        Category category = new Category(categoryName, bucket);

        System.out.print("Contexto (1 - Pessoal, 2 - Empresarial): ");
        int contextChoice = scanner.nextInt();
        scanner.nextLine();
        ExpenseContext context = (contextChoice == 1) ? ExpenseContext.PESSOAL : ExpenseContext.EMPRESARIAL;

        Deal deal = new Deal(value, LocalDate.now(), type, name, category, context);
        cashFlow.addDeal(deal);
        System.out.println("Movimentação registrada com sucesso!");
    }

    private static void addSellOnCredit() {
        System.out.print("Nome do cliente: ");
        String clientName = scanner.nextLine();
        Client client = new Client(clientName);

        System.out.print("Nome do produto (já cadastrado no estoque): ");
        String productName = scanner.nextLine();
        Product product = stock.findProduct(productName);

        if (product == null) {
            System.out.println("Produto não encontrado no estoque!");
            return;
        }

        System.out.print("Valor da venda: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nome da categoria: ");
        String categoryName = scanner.nextLine();
        Category category = new Category(categoryName, BudgetBucket.NECESSIDADE);

        sellOnCredit sale = new sellOnCredit(client, product, value, LocalDate.now(), "Venda fiado - " + productName, category);
        cashFlow.addDeal(sale);
        System.out.println("Venda fiado registrada com sucesso!");
    }

    private static void addBill() {
        System.out.print("Nome da conta: ");
        String name = scanner.nextLine();

        System.out.print("Valor: ");
        double value = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Dias até o vencimento: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        Bills bill = new Bills(name, value, LocalDate.now().plusDays(days), PaymentStatus.PENDENT);
        cashFlow.addBill(bill);
        System.out.println("Conta adicionada com sucesso!");
    }
}