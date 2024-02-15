package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] cantidadCompras=new int[6];
        double totalCompra=0.0;
        int intentosRealizados=0;
        int intentosMaximos=3;
        String usuario;
        String usuarioBD="usuario123";
        String contrasena;
        String contrasenaBD="123456";
        String correo;
        String correoBD="usuario123@gmail.com";
        String[] productos={"entrada de cangrejo de urrao","escalopes a la rigo","filete tour de francia","corvina de rigo",
        "coctel michel","jugos de urrao"};
        int[] precios={28000,35000,150000,80000,20000,18500};
        int opcionMenu;
        while (intentosRealizados < intentosMaximos) {
            System.out.println("ingrese el usuario ");
            usuario=sc.nextLine();
            if (usuario.equals(usuarioBD)) {
                System.out.println("ingrese la contraseña para: " + usuario);
                contrasena = sc.nextLine();
                if (contrasena.equals(contrasenaBD)) {
                    System.out.println("contraseña correcta");
                    System.out.println("ingrese el correo electronio");
                    correo=sc.nextLine();
                        if (correo.equals(correoBD)){
                            System.out.println("validacion exitosa");
                            do {
                                System.out.println("1. Ingresar orden");
                                System.out.println("2. terminar orden y calcular total");
                                System.out.println("3. modificar compra");
                                System.out.println("4. salir");

                                opcionMenu=sc.nextInt();

                                if (opcionMenu==1){
                                    while (true) {
                                        MostrarMenuProductos();
                                        System.out.println("escoja un producto");
                                        int opcionMenuProductos = sc.nextInt();
                                        if (opcionMenuProductos==7){
                                            break;
                                        }else {
                                            cantidadCompras = CantidadProductos(opcionMenuProductos, sc,cantidadCompras);

                                        }

                                    }

                                } else if (opcionMenu==2) {
                                    System.out.println("desea agregar propina? escoja 5, escoja 10, o ponga no para calcular total sin propina");
                                    sc.nextLine();
                                    String opcionPropina=sc.nextLine();
                                    if (opcionPropina.equals("10")) {
                                        totalCompra = CalcularTotal(cantidadCompras, precios)*1.1;
                                        System.out.println("el total de la compra es: " + totalCompra);
                                    } else if (opcionPropina.equals("5")) {
                                        totalCompra = CalcularTotal(cantidadCompras, precios)*1.05;
                                        System.out.println("el total de la compra es: " + totalCompra);
                                    } else if(opcionPropina.equals("no")){
                                        totalCompra = CalcularTotal(cantidadCompras, precios);
                                        System.out.println("el total de la compra es: " + totalCompra);
                                    }else{
                                        System.out.println("opcion incorrecta");
                                    }


                                } else if (opcionMenu==3) {
                                    System.out.println("modificacion de compras");
                                    System.out.println("escoja el numero del producto que quiere modificar");
                                    MostrarMenuProductos();
                                    int opcionMenuProductos = sc.nextInt();
                                    System.out.println("seleccione la cantidad de: " +productos[opcionMenuProductos-1]+"que desea actualizar");
                                    int nuevaCantidad=sc.nextInt();
                                    modificarCompras(cantidadCompras,opcionMenuProductos,nuevaCantidad);
                                } else if (opcionMenu==4) {
                                    System.out.println("hasta luego ");
                                }else {
                                    System.out.println("opcion incorrecta");
                                }


                            }while(opcionMenu!=4);
                            break;
                        }else {
                            System.out.println("correo equivocado");
                        }

                } else {
                    System.out.println("contraseña equivocada");
                }
            } else {
                System.out.println("usuario incorrecto");
            }
            intentosRealizados++;
        }
        if (intentosRealizados==intentosMaximos){
            System.out.println("se ha alcanzado el limite de intentos ");
        }



    }
    public static void MostrarMenuProductos(){
        System.out.println("1. entrada de cangrejo de urrao");
        System.out.println("2. escalopes a la rigo");
        System.out.println("3. filete tour de francia");
        System.out.println("4. corvina de rigo");
        System.out.println("5. coctel michel");
        System.out.println("6. jugos de urrao");
        System.out.println("7. Salir");
    }

    public static int[] CantidadProductos(int opcion, Scanner sc, int[]cantidadCompras){

        String[] mensajes = {
                "entrada de cangrejo de urrao",
                "escalopes a la rigo",
                "filete tour de francia",
                " corvina de rigo",
                "coctel michel",
                "jugos de urrao"
        };

        if (opcion >= 1 && opcion <= 6) {
            System.out.println("Ingrese la cantidad de " + mensajes[opcion - 1] + " que desea comprar");
            int opcionCantidades = sc.nextInt();
            cantidadCompras[opcion - 1] += opcionCantidades;
        } else if (opcion == 7) {
            System.out.println("Menú anterior");
        } else {
            System.out.println("Opción incorrecta");
        }

        return cantidadCompras;
    }
    public static double CalcularTotal(int[] cantidadProductos, int[] precios){
        Double totalCompra=0.0;
        for (int i=0;i<cantidadProductos.length;i++){
            totalCompra+=cantidadProductos[i]*precios[i];
        }
        return totalCompra;
    }
    public static void modificarCompras(int[] compras, int producto, int nuevaCantidad) {
        if (producto >= 1 && producto <= 6) {
            compras[producto - 1] = nuevaCantidad;
            System.out.println("Modificación exitosa.");
        } else {
            System.out.println("Opción de producto incorrecta.");
        }
    }

}