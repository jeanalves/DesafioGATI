package desafiogati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CRUD {
    
    private List<Cliente> clientes = new ArrayList<>();
    
    public void iniciar(){
        
        while(true){
            
            System.out.println("\n----------------CRUD----------------\n");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listagem");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Opcao : "); int opcao = readInt();

            if(opcao == 1){
                cadastrar();
            }
            else if(opcao == 2){
                listagem();
            }
            else if(opcao == 3){

            }
            else if(opcao == 4){
                deletar();
            }
            else if(opcao == 0){
                break;
            }
        }
    }
    
    /*
    private String nome;
    private String email;
    private String telefone;
    private String Endereco;
    private String numero;
    private String bairro;
    private String cep;
    private boolean ativo;
    */
    
    public void cadastrar(){
        
        System.out.println("\n----------------Cadastro----------------\n");
        Cliente cliente = new Cliente();
        
        System.out.print("Digite um id : "); cliente.setId(readInt());
        System.out.print("Digite um nome : "); cliente.setNome(readString());
        System.out.print("Digite um email : "); cliente.setEmail(readString());
        System.out.print("Digite um telefone : "); cliente.setTelefone(readString());
        System.out.print("Digite um endereco : "); cliente.setEndereco(readString());
        System.out.print("Digite um numero : "); cliente.setNumero(readString());
        System.out.print("Digite um bairro : "); cliente.setBairro(readString());
        System.out.print("Digite um cep : "); cliente.setCep(readString());
        System.out.print("Digite um Ativo (S/N) : "); cliente.setAtivo(readYN());
        
        this.clientes.add(cliente);
        
        System.out.println("Cliente cadastrado com sucesso");
        
    }
    
    public void listagem(){
        System.out.println("\n----------------Listagem----------------\n");
        for(Cliente cli: this.clientes){
            System.out.println(
                                cli.getId() + " " +
                                cli.getNome() + " " +
                                cli.getEmail() + " " +
                                cli.getTelefone() + " " +
                                cli.getEndereco() + " " +
                                cli.getNumero() + " " +
                                cli.getBairro() + " " +
                                cli.getCep() + " " +
                                cli.isAtivo()
                    );
        }
        
    }
    
    public void deletar(){
        System.out.println("\n----------------Deletar----------------\n");
        System.out.print("Digite o id do cliente que deseja deletar : ");
        int id = readInt();
        
        Cliente cliDel = null;
        
        //Procura pelo objeto que tem o id informado e o remove
        for(Cliente cli: this.clientes){
            
            if(cli.getId() == id){
                cliDel = cli;
            }
            
        }
        
        this.clientes.remove(cliDel);
        
        System.out.println("Cliente removido com sucesso!");
        
    }
    //Funçoes do CRUD
    
    //Faz a leitura do teclado e retorna uma string
    public static String readdString(){
        String read;
        try (Scanner scanIn = new Scanner(System.in)) {
            read = scanIn.nextLine();
        }
        
        
        return read;
    }
    
    public static String readString(){
        String read = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            read = bufferRead.readLine();
        } catch (IOException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return read;
    }    
    //Faz a leitura do teclado e retorna um valor inteiro
    public int readInt(){
        Scanner scanIn = new Scanner(System.in);
        int read = Integer.parseInt(scanIn.nextLine());
        return read;
    }
    
    //Faz a leitura do teclado e de acordo com a tecla precionada(S ou N) retorna um valor boleano
    public static boolean readYN(){
        String read = " ";
        
        do{
            try{
                Scanner scanIn = new Scanner(System.in);
                read = scanIn.nextLine();
            }
            catch(Exception e){
                
            }
            
            if(null != read)switch (read) {
                case "s":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.print("Entrada inválida, digite S ou N!: ");
                    break;
            }
        }while(read != "s"|| read != "n");
        
        return false;
    }
    
}