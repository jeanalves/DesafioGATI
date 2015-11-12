package desafiogati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CRUD {
    
    private List<Cliente> clientes = new ArrayList<>();
    
    public void iniciar(){
        
        while(true){
            
            System.out.println("\n\n----------------CRUD----------------\n");
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
                atualizar();
            }
            else if(opcao == 4){
                deletar();
            }
            else if(opcao == 0){
                break;
            }
        }
    }
    
    public void cadastrar(){
        
        System.out.println("\n\n----------------Cadastro----------------\n");
        Cliente cliente = new Cliente();
        
        System.out.print("Digite um id : "); cliente.setId(readInt());
        System.out.print("Digite um nome : "); cliente.setNome(readString());
        System.out.print("Digite um email : "); cliente.setEmail(readString());
        System.out.print("Digite um telefone : "); cliente.setTelefone(readString());
        System.out.print("Digite um endereco : "); cliente.setEndereco(readString());
        System.out.print("Digite um numero : "); cliente.setNumero(readString());
        System.out.print("Digite um bairro : "); cliente.setBairro(readString());
        System.out.print("Digite um cep : "); cliente.setCep(readString());
        System.out.print("Ativo? (S/N) : "); cliente.setAtivo(readYN());
        
        //Adciona o objeto cliente a ArrayList clientes
        this.clientes.add(cliente);
        
        System.out.println("Cliente cadastrado com sucesso");
        pausa();
    }
    
    public void listagem(){
        System.out.println("\n\n----------------Listagem----------------\n");
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
        pausa();
    }
    
    public void atualizar(){
        System.out.println("\n\n----------------Atualizar----------------\n");
        
        Cliente cliente = new Cliente();
        
        System.out.print("Digite o ID do cliente que deseja altarar : "); cliente.setId(readInt());
        
        //Busca o objeto cliente e se o mesmo existir o altera
        cliente = retornaCliente(cliente.getId());
        
        if(cliente != null){
            
            System.out.print("Digite um novo nome : "); cliente.setNome(readString());
            System.out.print("Digite um novo email : "); cliente.setEmail(readString());
            System.out.print("Digite um novo telefone : "); cliente.setTelefone(readString());
            System.out.print("Digite um novo endereco : "); cliente.setEndereco(readString());
            System.out.print("Digite um novo numero : "); cliente.setNumero(readString());
            System.out.print("Digite um novo bairro : "); cliente.setBairro(readString());
            System.out.print("Digite um novo cep : "); cliente.setCep(readString());
            System.out.print("Ativo? (S/N) : "); cliente.setAtivo(readYN());

            System.out.println("\nCliente atualizado com sucesso!");
            
        }
        else{
            System.out.println("\nO ID informado não existe, tente novamente!");
        }
        pausa();
    }
    
    public void deletar(){
        System.out.println("\n\n----------------Deletar----------------\n");
        System.out.print("Digite o id do cliente que deseja deletar : ");
        int id = readInt();
        
        this.clientes.remove(retornaCliente(id));
        
        System.out.println("Cliente removido com sucesso!");
        pausa();
    }
    
    
    
    //Funçoes do CRUD
    
    //Faz a leitura do teclado e retorna uma string
    public static String readString(){
        String read = "";
        try{
            Scanner scanIn = new Scanner(System.in);
            read = scanIn.nextLine();
        }catch(Exception e){
            
        }        
        return read;
    }
        
    //Faz a leitura do teclado e retorna um valor inteiro
    public int readInt(){
        int read = 0;
        try{
            Scanner scanIn = new Scanner(System.in);
            read = Integer.parseInt(scanIn.nextLine());
        }catch(Exception e){   
        }
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
    
    //Verifica se existe cliente e retorna objeto se o achou
    public Cliente retornaCliente(int id){
        
        for(Cliente  cli : this.clientes){
            
            if(cli.getId() == id){
                return cli;
            }
            
        }
        return null;
    }
    
    //Pausa a linha de texto para melhor visualizala
    public void pausa(){
        System.out.print("\nTecle qualquer tecla para continuar!");
        try{
            Scanner scanIn = new Scanner(System.in);
            String read = scanIn.nextLine();
        }catch(Exception e){
        }
    }
    
}