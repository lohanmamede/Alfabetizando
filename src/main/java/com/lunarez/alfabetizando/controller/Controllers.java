package com.lunarez.alfabetizando.controller; // :D

/**
 * Esta classe é responsável pelo armazenamento e disponibilização dos
 * controllers das telas da aplicação, para que eles possam ser usados nos
 * controllers de outras telas, possibilitando o relacionamento entre elas
 *
 * @author eres
 */
public class Controllers {

    // ------------------------------------------------------------------ Campos
    private static TelaLoginController telaLoginController;
    private static TelaLoginEludikaController telaLoginEludikaController;
    private static TelaCriarUsuarioController telaCriarUsuarioController;
    private static TelaPrincipalController telaPrincipalController;
    
    private static TelaJogoCliqueNasLetrasController 
            telaJogoCliqueNasLetrasController;
    
    private static TelaJogoCliqueNasLetrasInicioController 
            telaJogoCliqueNasLetrasInicioController;
    

    // ------------------------------------------------------- Getters e Setters    
    public static TelaLoginController getTelaLoginController() {

        return Controllers.telaLoginController;
    }

    public static void setTelaLoginController(TelaLoginController 
            telaLoginController) {

        Controllers.telaLoginController = telaLoginController;
    }
    
    public static TelaLoginEludikaController getTelaLoginEludikaController() {

        return Controllers.telaLoginEludikaController;
    }

    public static void setTelaLoginEludikaController(TelaLoginEludikaController 
            telaLoginEludikaController) {

        Controllers.telaLoginEludikaController = telaLoginEludikaController;
    }
    
    public static TelaCriarUsuarioController getTelaCriarUsuarioController() {

        return Controllers.telaCriarUsuarioController;
    }

    public static void setTelaCriarUsuarioController(TelaCriarUsuarioController 
            telaCriarUsuarioController) {

        Controllers.telaCriarUsuarioController = telaCriarUsuarioController;
    }
    
    public static TelaPrincipalController getTelaPrincipalController() {

        return Controllers.telaPrincipalController;
    }

    public static void setTelaPrincipalController(TelaPrincipalController 
            telaPrincipalController) {

        Controllers.telaPrincipalController = telaPrincipalController;
    }
    
    public static TelaJogoCliqueNasLetrasController 
        getTelaJogoCliqueNasLetrasController() {

        return Controllers.telaJogoCliqueNasLetrasController;
    }

    public static void setTelaJogoCliqueNasLetrasController(
            TelaJogoCliqueNasLetrasController 
                    telaJogoCliqueNasLetrasController) {

        Controllers.telaJogoCliqueNasLetrasController = 
                telaJogoCliqueNasLetrasController;
    }

    public static TelaJogoCliqueNasLetrasInicioController 
        getTelaJogoCliqueNasLetrasInicioController() {
            
        return Controllers.telaJogoCliqueNasLetrasInicioController;
    }

    public static void setTelaJogoCliqueNasLetrasInicioController(
            TelaJogoCliqueNasLetrasInicioController 
                    telaJogoCliqueNasLetrasInicioController) {
        
        Controllers.telaJogoCliqueNasLetrasInicioController = 
                telaJogoCliqueNasLetrasInicioController;
    }
}
