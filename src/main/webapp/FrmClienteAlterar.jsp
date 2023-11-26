<!DOCTYPE html>
<html>
    <head><title>Cadastro de Cliente - Alterar</title></head><body>
        <h1>Cadastro de Cliente - Alterar</h1>
        <form name="FrmCliente" method="post" action="servlet/ClienteAlterar">
            ClienteId: <input type=text name="ClienteId"> <p>
            Nome: <input type=text size="100" name="Nome"> <p>
            Cpf (Somente números): <input type=text name="CPF"> <p>
            <input type="reset" value="Limpar">
            <input type="submit" name="Alterar" value="Alterar"> <p>
            <a href="menu.jsp"> Menu </a> <p>
        </form>
    </body>
</html>	