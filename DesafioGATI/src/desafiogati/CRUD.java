package desafiogati;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CRUD {
    
    private List<Cliente> clientes = new ArrayList<>();
    Util util = new Util(this.clientes);
    
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
        UtilMensagem msg;
        
        System.out.print("Digite um id : "); cliente.setId(readInt());
        
        msg = new UtilMensagem();
        msg.setCampo(UtilMensagem.Campo.NOME);
        cliente.setNome(readString(msg,"Digite um nome : "));
        
        msg = new UtilMensagem();
        msg.setCampo(UtilMensagem.Campo.EMAIL);
        cliente.setEmail(readString(msg,"Digite um email : "));
        
        System.out.print("Digite um telefone : "); cliente.setTelefone(readString());
        System.out.print("Digite um endereco : "); cliente.setEndereco(readString());
        System.out.print("Digite um numero : "); cliente.setNumero(readString());
        System.out.print("Digite um bairro : "); cliente.setBairro(readString());
        System.out.print("Digite um cep : "); cliente.setCep(readString());
        System.out.print("Ativo? (S/N) : "); cliente.setAtivo(readSN());
        
        //Adciona o objeto cliente a ArrayList clientes
        this.clientes.add(cliente);
        
        System.out.println("Cliente cadastrado com sucesso");
        pausa();
    }
    
    //Lista todos os registros de clientes sem utilizar filtro
    public void listagem(){
        List<Cliente> tempCli = new ArrayList<>();
        
        System.out.println("\n\n----------------Listagem----------------\n");
        
        System.out.println("Escolha uma forma de listagem");
        System.out.println("1 - Normal(Sem filtro)");
        System.out.println("2 - Nome(Com filtro)");
        System.out.println("3 - Email(Com filtro)");
        System.out.println("4 - Ativo(Com filtro)");
        System.out.print("Opcao : ");int opcao = readInt();
        
        if(opcao == 1){
            tempCli=listagemNormal();
        }
        else if(opcao == 2){
            tempCli=listagemNome();
        }
        else if(opcao == 3){
            tempCli=listagemEmail();
        }
        else if(opcao == 4){
            tempCli=listagemAtivo();
        }
        
        for(Cliente cli: tempCli){
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
    
    //Retorna a lista padrão para listagem
    public List<Cliente> listagemNormal(){     
        return this.clientes;
    }
    
    //Filtra por nome e retorna a lista filtrada
    public List<Cliente> listagemNome(){
        
        System.out.print("Digite o nome que deseja filtrar: ");
        String nome = readString();
        
        List<Cliente> tempCli = new ArrayList<>();
        
        for(Cliente cli: this.clientes){
            
            if(cli.getNome().equals(nome)){
                tempCli.add(cli);
            }
            
        }
        return tempCli;
    }
    
    //Filtra por email e retorna a lista filtrada
    public List<Cliente> listagemEmail(){
        
        System.out.print("Digite o email que deseja filtrar: ");
        String email = readString();
        
        List <Cliente> tempCli = new ArrayList<>();
        
        for(Cliente cli: this.clientes){
            
            if(cli.getEmail().equals(email)){
                tempCli.add(cli);
            }
            
        }
        
        return tempCli;
    }
    
    //Filtra por ativo (Sim ou não) e retorna a lista filtrada
    public List<Cliente> listagemAtivo(){
        
        System.out.print("Digite se ativo que deseja filtrar (S/N): ");
        boolean ativo = readSN();
        
        List <Cliente> tempCli = new ArrayList<>();
        
        for(Cliente cli: this.clientes){
            
            if(cli.isAtivo() == ativo){
                tempCli.add(cli);
            }
            
        }
        
        return tempCli;
    }
    
    
    //Atualiza o registro de um cliente
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
            System.out.print("Ativo? (S/N) : "); cliente.setAtivo(readSN());

            System.out.println("\nCliente atualizado com sucesso!");
            
        }
        else{
            System.out.println("\nO ID informado não existe, tente novamente!");
        }
        pausa();
    }
    
    //Deleta registro de cliente através de ID informado
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
        UtilMensagem msg;
        String read = "";
        try{
            Scanner scanIn = new Scanner(System.in);
            read = scanIn.nextLine();
        }catch(Exception e){
        }
        
        return read;
    }
    
    //Faz a leitura do teclado valida a mensagem e retorna a mesma, tambem imprime texto solicitando a entrada
    public String readString(UtilMensagem msg,String texto){
        System.out.print(texto);
        do{
            try{
                Scanner scanIn = new Scanner(System.in);
                msg.setMensagemString(scanIn.nextLine());
            }catch(Exception e){
            }
            msg = util.validar(msg);
            if(!msg.isValido()){
                System.out.print(msg.getMensagemString() + " Tente novamente!\n" + texto);
            }
        }while(!msg.isValido());
        
        return msg.getMensagemString();
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
    public static boolean readSN(){
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