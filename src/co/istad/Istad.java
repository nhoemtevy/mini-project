package co.istad;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public class Istad {

    public static void main(String[] args) {
        List<co.istad.Product> productList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int newPage = 1;
        int rowsPage = 3;
        int Id;
        String name;


        System.out.println("\n" +
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    \n" +
                "STOCK MANAGEMENT SYSTEM");

        do {
            Table table = new Table(9,BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
            table.addCell("".repeat(3) + " | *)Display" + "".repeat(3));
            table.addCell("".repeat(3) + " | W)rite" + "".repeat(3));
            table.addCell("".repeat(3) + " | R)ead" + "".repeat(3));
            table.addCell("".repeat(3) + " | U)pdate" + "".repeat(3));
            table.addCell("".repeat(3) + " | D)elete" + "".repeat(3));
            table.addCell("".repeat(3) + " | F)irst" + "".repeat(3));
            table.addCell("".repeat(3) + " | P)revious" + "".repeat(3));
            table.addCell("".repeat(3) + " | N)ext" + "".repeat(3));
            table.addCell("".repeat(3) + " | L)last" + "".repeat(3));
            table.addCell("".repeat(3) + " | S)earch" + "".repeat(3));
            table.addCell("".repeat(3) + " | G)oto" + "".repeat(3));
            table.addCell("".repeat(3) + " | Se)t row" + "".repeat(3));
            table.addCell("".repeat(3) + " | H)elp" + "".repeat(3));
            table.addCell("".repeat(3) + " | E)xit" + "".repeat(3));
            System.out.println(table.render());
            System.out.println();
            System.out.print("Command ———>\t");
            String options = scanner.nextLine();
            switch (options) {
                case "*"-> {
                    display(productList);
                }
                case "w", "W" -> {
                    write(productList);
                }
                case "r", "R" -> {
                    read(productList);
                }
                case "u", "U" -> {
                    update(productList);
                }
                case "d", "D" -> {
                    delete(productList);
                }
                case "f", "F" -> {

                }
                case "p", "P" -> {

                }
                case "n", "N" -> {

                }
                case "l", "L" -> {

                }
                case "s", "S" -> {

                }
                case "g", "G" -> {

                }
                case "se", "Se" -> {

                }
                case "h", "H" -> {
                    help();
                }
                case "e", "E" -> {
                    System.out.println("~ ".repeat(20));
                    System.out.println("\t\t\t\tExit");
                    System.out.println("~ ".repeat(20));
                }
                default ->{
                    System.out.println("~ ".repeat(30));
                    System.out.println("\t\t\t\tInput Is Invalid Option");
                    System.out.println("~ ".repeat(30));
                }
            }
        }while (true);
    }

    private static void delete(List<Product> productList) {
    }

    private static void update(List<Product> productList) {
        Random random = new Random();
        Product product = new Product();
        boolean isFound = false;
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("What do you want to update?");
            Table tableToUpdate = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.SURROUND);
            tableToUpdate.addCell(" ".repeat(3) + "1. All" + " ".repeat(3));
            tableToUpdate.addCell(" ".repeat(3) + "2. Name" + " ".repeat(3));
            tableToUpdate.addCell(" ".repeat(3) + "3. Quantity" + " ".repeat(3));
            tableToUpdate.addCell(" ".repeat(3) + "4. Price" + " ".repeat(3));
            tableToUpdate.addCell(" ".repeat(3) + "5. Go Back" + " ".repeat(3));
            System.out.println(tableToUpdate.render());
            try {
                System.out.println("Choose option 1-5:");
                int option1 = Integer.parseInt(scanner.nextLine());
                switch (option1) {
                    case 1 -> {
                        System.out.print("ID:");
                        scanner = new Scanner(System.in);
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name:");
                        String name = scanner.nextLine();
                        System.out.print("UnitPrice:");
                        double unitPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Qty:");
                        int qty = scanner.nextInt();
                        product.setImportDate(LocalDate.now());
                        productList.add(new Product(id, name, unitPrice, qty, LocalDate.now()));
                        for (Product eProduct : productList) {
                            Table table = getTable(eProduct);
                            System.out.println(table.render());
                        }
                        System.out.print( "\nAre you sure to add new this record? [Y/y] or [N/n] : ");
                        String options = scanner.next();
                        switch (options) {
                            case "y","Y" -> {
                                System.out.println("\nProduct added successfully!");
                            }
                            case "n","N" -> {
                                productList.remove(product);
                                System.out.println("\nProduct is not added!");
                            }
                            default -> System.out.println("\nInvalid options!");
                        }
                    }
                    case 2 ->{
                        System.out.println("Enter new product name : ");
                        String newProductName = scanner.nextLine();
                        product.setName(newProductName);
                        for (Product eProduct : productList) {
                            Table table = getTable(eProduct);
                            System.out.println(table.render());
                        }
                        System.out.print( "\nAre you sure to add new this record? [Y/y] or [N/n] : ");
                        String options = scanner.next();
                        switch (options) {
                            case "y","Y" -> {
                                System.out.println("\nProduct added successfully!");
                            }
                            case "n","N" -> {
                                productList.remove(product);
                                System.out.println("\nProduct is not added!");
                            }
                            default -> System.out.println("\nInvalid options!");
                        }
                    }
                    case 3 ->{
                        System.out.println("Enter new product QTY : ");
                        Integer newProductQty = Integer.valueOf(scanner.nextLine());
                        product.setQty(newProductQty);
                        for (Product eProduct : productList) {
                            Table table = getTable(eProduct);
                            System.out.println(table.render());
                        }
                        System.out.print( "\nAre you sure to add new this record? [Y/y] or [N/n] : ");
                        String options = scanner.next();
                        switch (options) {
                            case "y","Y" -> {
                                System.out.println("\nProduct added successfully!");
                            }
                            case "n","N" -> {
                                productList.remove(product);
                                System.out.println("\nProduct is not added!");
                            }
                            default -> System.out.println("\nInvalid options!");
                        }
                    }
                    case 4 ->{
                        System.out.println("Enter new product unitPrice : ");
                        Integer newProductPrice = Integer.valueOf(scanner.nextLine());
                        product.setName(String.valueOf(newProductPrice));
                        for (Product eProduct : productList) {
                            Table table = getTable(eProduct);
                            System.out.println(table.render());
                        }
                        System.out.print( "\nAre you sure to add new this record? [Y/y] or [N/n] : ");
                        String options = scanner.next();
                        switch (options) {
                            case "y","Y" -> {
                                System.out.println("\nProduct added successfully!");
                            }
                            case "n","N" -> {
                                productList.remove(product);
                                System.out.println("\nProduct is not added!");
                            }
                            default -> System.out.println("\nInvalid options!");
                        }
                    }
                    case 5 -> {System.out.println("Go Back : ");}
                    default -> {throw new IllegalStateException("Unexpected: " + option1);}
                }


            } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void display( List<Product> productList) {
        Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        tableDisplay.addCell(" ".repeat(3) + "ID" + " ".repeat(3)  );
        tableDisplay.addCell(" ".repeat(3) + "Name" + " ".repeat(3));
        tableDisplay.addCell(" ".repeat(3) + "Unit Price" + " ".repeat(3));
        tableDisplay.addCell(" ".repeat(3) + "Qty" + " ".repeat(3));
        tableDisplay.addCell(" ".repeat(3) + "Imported Date" + " ".repeat(3));

        for (Product product : productList) {
            tableDisplay.addCell(" ".repeat(3) + product.getId());
            tableDisplay.addCell(" ".repeat(3) + product.getName());
            tableDisplay.addCell(" ".repeat(3) + product.getPrice().toString());
            tableDisplay.addCell(" ".repeat(3) + product.getQty().toString());
            tableDisplay.addCell(" ".repeat(3) + product.getImportDate().toString());
        }
        System.out.println(tableDisplay.render());
        System.out.println("o" + "~ ".repeat(35) +"o");
        int rowsPage = 1;
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPage);
        int newPage = 3;
        System.out.println("Page " + newPage + " of " + totalPages + " ".repeat(40) + "Total records : " + productList.size());
        System.out.println("o" +"~ ".repeat(35) +"o");
    }

    public static void write( List<Product> productList) {
            Random random = new Random();
            Product product = new Product();
            Scanner scanner = new Scanner(System.in);
            try {
                int randomNumber = random.nextInt(20) + 1;
                System.out.println("Product ID  :" + randomNumber );
                System.out.print("Name        :");
                String name  = product.setName(scanner.next());
                System.out.print("UnitPrice   :");
                double unitPrice =  product.setPrice(scanner.nextDouble());
                System.out.print("Qty         :");
                int qty = product.setQty(scanner.nextInt());
                product.setImportDate(LocalDate.now());
                productList.add(new Product(randomNumber, name, unitPrice, qty, LocalDate.now()));
                for (Product eProduct : productList) {
                   Table table = getTable(eProduct);
                    System.out.println(table.render());
                }
                System.out.print( "\nAre you sure to add this record? [Y/y] or [N/n] : ");
                String options = scanner.next();
                switch (options) {
                    case "y","Y" -> {
                        System.out.println("\nProduct added successfully!");
                    }
                    case "n","N" -> {
                        productList.remove(product);
                        System.out.println("\nProduct is not added!");
                    }
                    default -> System.out.println("\nInvalid options!");
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    private static Table getTable(Product eProduct) {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
        table.addCell("ID" + " ".repeat(20) + ": " + eProduct.getId());
        table.addCell("Name" + " ".repeat(18) + ": " + eProduct.getName());
        table.addCell("Unit Price" + " ".repeat(12) + ": " + eProduct.getPrice());
        table.addCell("Qty" + " ".repeat(19) + ": " + eProduct.getQty());
        table.addCell("Imported Date" + " ".repeat(9) + ": " + eProduct.getImportDate());
        return table;
    }
    public static void read(List<Product> productList) {
        Scanner sc = new Scanner(System.in);
        boolean isFound = false;
        try {
            System.out.print("Read by Id: ");
            int productID = Integer.parseInt(sc.nextLine());
            for (Product eProduct : productList) {
                if (eProduct.getId()==(productID)) {
                    Table table = getTable(eProduct);
                    System.out.println(table.render());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Product with ID : "+productID+" is not found");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void help() {
        Table tableHelp = new Table(1, BorderStyle.CLASSIC_COMPATIBLE_LIGHT_WIDE,ShownBorders.SURROUND);
        tableHelp.addCell("1.   Press   * : Display all record of products                          ");
        tableHelp.addCell("2.   Press   w : Add new product                                         ");
        tableHelp.addCell("     Press   w ->#proname-unitPrice-qty : shortcut to add new product    ");
        tableHelp.addCell("3.   Press   r : Read Content any content                                ");
        tableHelp.addCell("     Press   r#proId : shortcut to read product by Id                    ");
        tableHelp.addCell("4.   Press   u : Update Data                                             ");
        tableHelp.addCell("5.   Press   d : Delete Data                                             ");
        tableHelp.addCell("     Press   d#proId : shortcut to delete product by Id                  ");
        tableHelp.addCell("6.   Press   f : Display First page                                      ");
        tableHelp.addCell("7.   Press   p : Display Previous Page                                   ");
        tableHelp.addCell("8.   Press   n : Display Next Page                                       ");
        tableHelp.addCell("9.   Press   l : Display last page                                       ");
        tableHelp.addCell("10.  Press   s : Search product by name                                  ");
        tableHelp.addCell("11.  Press   h : Help                                                    ");
        System.out.println(tableHelp.render());
    }
}
