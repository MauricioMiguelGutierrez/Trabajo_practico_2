package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int menu (int opcion) {
        System.out.println("Menu");
        System.out.println("1 – Crear Producto");
        System.out.println("2 – Mostrar productos");
        System.out.println("3 – Modificar producto (sólo puede modificar: descripción, precio unitario, origen fabricación \r\n"
                + "o categoría)");
        System.out.println("4 – Salir");
        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    private static int menuOpcionFabricacion (int opcion) {
        System.out.println("Menu");
        System.out.println("1 – Argentina");
        System.out.println("2 – China");
        System.out.println("3 – Brasil");
        System.out.println("4 – Uruguay");
        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    private static int menuOpcionCategoria (int opcion) {
        System.out.println("Menu");
        System.out.println("1 – Telefonía");
        System.out.println("2 – Informática");
        System.out.println("3 –  Electro hogar");
        System.out.println("4 – Herramientas");
        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    private static int menuModificar (int opcion) {
        System.out.println("Modificar");
        System.out.println("1- Descripcion");
        System.out.println("2- Precio Unitario");
        System.out.println("3- Origen Fabricacion");
        System.out.println("4- Cateogoria");
        opcion=scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    public static void main(String[] args) {
        int op=0,opModificar=0;
        List<Producto> productos = new ArrayList<>();
        do {
            op = menu(op);
            switch(op) {
                case 1:
                    Producto producto = new Producto();
                    productos.add(cargarDatos(producto,productos));
                    break;
                case 2:
                    System.out.println("lista de productos");
                    try{
                        productos.forEach(p->System.out.println(p.toString()));
                    }catch (Exception e) {
                        System.out.println("No hay productos");
                    }
                    break;
                case 3:
                    System.out.println("Modificar productos");
                    try{
                        System.out.println("Ingrese codigo para buscar un producto: ");
                        Producto productoModificar = buscarProducto(scanner.nextLine(),productos);
                        if(productoModificar == null) {
                            throw new Exception("No se encontro el producto");
                        }
                        modificarProducto(menuModificar(opModificar),productoModificar);
                    }catch (Exception e) {
                        System.out.println("No se encontro el producto");
                    }
                    break;
                case 4:
                    System.out.println("fin del programa");
                    break;
                default: System.out.println("Ingrese opcion valida");
            }
        }while(op != 4);
    }
    private static Producto cargarDatos(Producto producto,List<Producto> productos) {
        String codigo;
        do {
            try {
                System.out.println("Ingrese codigo: ");
                codigo = scanner.nextLine();
                if (buscarProducto(codigo, productos) != null) {
                    throw new Exception("El código del producto ya existe.");
                }
                producto.setCodigo(codigo);
            } catch (Exception e) {
                System.out.println("Error al ingresar el codigo: " + e.getMessage());
                codigo = null;
            }
        } while (codigo == null);
        System.out.println("Ingrese descripcion: ");
        producto.setDescripcion(scanner.nextLine());
        try {
            System.out.println("Ingrese precio unitario: ");
            while (!scanner.hasNextFloat()) {
                System.out.println("Eso no es un número. Por favor, ingrese un número válido para el precio unitario:");
                scanner.nextLine(); // descarta la entrada incorrecta
            }
            producto.setPrecioUnitario(scanner.nextFloat());
            scanner.nextLine(); // consume el restante carácter de nueva línea
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al ingresar el precio unitario: " + e.getMessage());
        }
        int op =0;
        System.out.println("Ingrese Origen de fabricacion: ");
        op=menuOpcionFabricacion(op);
        switch(op) {
            case 1:
                producto.setOrigendeFabricacion(Producto.OrigenFabricacion.ARGENTINA);
                break;
            case 2:
                producto.setOrigendeFabricacion(Producto.OrigenFabricacion.CHINA);
                break;
            case 3:
                producto.setOrigendeFabricacion(Producto.OrigenFabricacion.BRASIL);
                break;
            case 4:
                producto.setOrigendeFabricacion(Producto.OrigenFabricacion.URUGUAY);
                break;
            default:
                System.out.println("no ingreso un valor valido, se selecciona Argentina por defecto");
        }
        System.out.println("Origen de fabricacion: "+producto.getOrigendeFabricacion());
        int opCategoria =0;
        System.out.println("Ingrese Categoria: ");
        opCategoria=menuOpcionCategoria (opCategoria);
        switch(opCategoria) {
            case 1:
                producto.setCategoria(Producto.Categoria.TELEFONIA);
                break;
            case 2:
                producto.setCategoria(Producto.Categoria.INFORMATICA);
                break;
            case 3:
                producto.setCategoria(Producto.Categoria.ELECTROHOGAR);
                break;
            case 4:
                producto.setCategoria(Producto.Categoria.HERRAMIENTAS);
                break;
            default:
                System.out.println("no ingreso un valor valido, se selecciona TELEFONIA por defecto");
                producto.setCategoria(Producto.Categoria.TELEFONIA);
        }
        System.out.println("Categoria: "+producto.getCategoria());
        return producto;
    }
    private static Producto buscarProducto(String codigo, List<Producto> productos) {
        Producto producto = new Producto();
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    private static void modificarProducto(int opcion, Producto productoModificar) {
        switch(opcion) {
            case 1:
                System.out.println("Ingrese descripcion: ");
                productoModificar.setDescripcion(scanner.nextLine());
                break;
            case 2:
                System.out.println("Ingrese precio unitario: ");
                while (!scanner.hasNextFloat()) {
                    System.out.println("Eso no es un número. Por favor, ingrese un número válido para el precio unitario:");
                    scanner.nextLine();
                }
                break;
            case 3:
                int op =0;
                System.out.println("Ingrese Origen de fabricacion: ");
                op=menuOpcionFabricacion(op);
                switch(op) {
                    case 1:
                        productoModificar.setOrigendeFabricacion(Producto.OrigenFabricacion.ARGENTINA);
                        break;
                    case 2:
                        productoModificar.setOrigendeFabricacion(Producto.OrigenFabricacion.CHINA);
                        break;
                    case 3:
                        productoModificar.setOrigendeFabricacion(Producto.OrigenFabricacion.BRASIL);
                        break;
                    case 4:
                        productoModificar.setOrigendeFabricacion(Producto.OrigenFabricacion.URUGUAY);
                        break;
                    default:
                        System.out.println("no ingreso un valor valido, se selecciona Argentina por defecto");
                        productoModificar.setOrigendeFabricacion(Producto.OrigenFabricacion.ARGENTINA);
                }
                System.out.println("Origen de fabricacion: "+productoModificar.getOrigendeFabricacion());
                break;
            case 4:
                int opCategoria =0;
                System.out.println("Ingrese Categoria: ");
                opCategoria=menuOpcionCategoria (opCategoria);
                switch(opCategoria) {
                    case 1:
                        productoModificar.setCategoria(Producto.Categoria.TELEFONIA);
                        break;
                    case 2:
                        productoModificar.setCategoria(Producto.Categoria.INFORMATICA);
                        break;
                    case 3:
                        productoModificar.setCategoria(Producto.Categoria.ELECTROHOGAR);
                        break;
                    case 4:
                        productoModificar.setCategoria(Producto.Categoria.HERRAMIENTAS);
                        break;
                    default:
                        System.out.println("no ingreso un valor valido, se selecciona TELEFONIA por defecto");
                        productoModificar.setCategoria(Producto.Categoria.TELEFONIA);
                }
                System.out.println("Categoria: "+productoModificar.getCategoria());
                break;
            default:
        }
    }
}

