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
        
        if(msg.getMensagemString().length() > caracteresMinimos && msg.getMensagemString().length() < caracteresMaximos){
            msg.setValido(true);
        }
        else{
            msg.setValido(false);
            msg.setMensagemString("O nome deve conter entre 3 e 100 caracteres!");
        }
        this.msg = msg;
    }
    
    //Valida o campo email
    public void validaEmail(List<Cliente> cliente, UtilMensagem msg){
        int caracteresMinimos = 3;
        int caracteresMaximos = 100;
        
        if(msg.getMensagemString().length() != caracteresMinimos && msg.getMensagemString().length() < caracteresMaximos){
            msg.setValido(true);
        }else{
            msg.setValido(false);
            msg.setMensagemString("O campo email de conter entre 1 e 100 caracteres!\n");
        }
        
        
        for(Cliente cli: cliente){
            if(cli.getEmail().equals(msg.getMensagemString())){
                msg.setValido(false);
                msg.setMensagemString(msg.getMensagemString() + "Email já exitente!");
            }
        }
        this.msg = msg;
    }
    
}
