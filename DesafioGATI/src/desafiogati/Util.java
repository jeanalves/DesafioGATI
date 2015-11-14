package desafiogati;

import java.util.List;

public class Util {

    public Util(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    private final List<Cliente> clientes;
    private UtilMensagem msg;
    
    public UtilMensagem validar(UtilMensagem msg){
        
        //Validação de ID
        if(msg.getCampo().equals(UtilMensagem.Campo.ID)){
            validaId(this.clientes,msg);
        }//Validação do nome
        else if(msg.getCampo().equals(UtilMensagem.Campo.NOME)){
            validaNome(msg);
        }//Validação do email
        else if(msg.getCampo().equals(UtilMensagem.Campo.EMAIL)){
            validaEmail(this.clientes,msg);
        }//Validação do telefone
        else if(msg.getCampo().equals(UtilMensagem.Campo.TELEFONE)){
            validaTelefone(msg);
        }//Validação do numero
        else if(msg.getCampo().equals(UtilMensagem.Campo.NUMERO)){
            validaNumero(msg);
        }//Validação do bairro
        else if(msg.getCampo().equals(UtilMensagem.Campo.BAIRRO)){
            validaBairro(msg);
        }//Validação do cep
        else if(msg.getCampo().equals(UtilMensagem.Campo.CEP)){
            validaCep(msg);
        }
        else{
            this.msg = msg;
            this.msg.setValido(true);
        }
        return this.msg;
    }
    
    
    
    //Valida campo id Verificando se exite outro igual
    public void validaId(List<Cliente> cliente,UtilMensagem msg){
        
        for(Cliente cliTemp: cliente){
            
            if(msg.getMensagemInt() == cliTemp.getId()){
                msg.setValido(false);
                msg.setMensagemString("O id já existe!");
            }    
        }
        this.msg = msg;
    }
    
    //valida o campo nome
    public void validaNome(UtilMensagem msg){               
        int caracteresMinimos = 3;
        int caracteresMaximos = 100;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O nome deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        this.msg = msg;
    }
    
    //Valida o campo email
    public void validaEmail(List<Cliente> cliente, UtilMensagem msg){
        int caracteresMinimos = 0;
        int caracteresMaximos = 100;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }else{
            msg.setValido(false);
            msg.setMensagemString("O campo email deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        
        
        for(Cliente cli: cliente){
            if(cli.getEmail().equals(msg.getMensagemString())){
                msg.setValido(false);
                msg.setMensagemString(msg.getMensagemString() + "Email já exitente!");
            }
        }
        this.msg = msg;
    }
    
    //Valida  o campo telefone
    public void validaTelefone(UtilMensagem msg){
        
        int caracteresMinimos = 1;
        int caracteresMaximos = 25;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O campo telefone deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        
        this.msg = msg;
    }
    
    //Valida  o campo numero
    public void validaNumero(UtilMensagem msg){

        int caracteresMinimos = 1;
        int caracteresMaximos = 10;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O campo numero deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        
        this.msg = msg;
    }

    //Valida  o campo bairro
    public void validaBairro(UtilMensagem msg){
        int caracteresMinimos = 1;
        int caracteresMaximos = 255;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O campo bairro deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        
        this.msg = msg;
    }
    
    //Valida  o campo CEP
    public void validaCep(UtilMensagem msg){
        int caracteresMinimos = 0;
        int caracteresMaximos = 10;
        
        if(msg.getMensagemString().length() >= caracteresMinimos && msg.getMensagemString().length() <= caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O campo CEP deve conter entre " + caracteresMinimos + " e " + caracteresMaximos + " caracteres!");
        }
        
        this.msg = msg;
    }
    
    /*
    public void validaAtivo(){
        
    }
    */
}

