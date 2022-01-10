$(document).ready(function(){
    var incluiu = document.getElementById("incluiu").value;
    if(incluiu === "true"){
        var hasError = false;
        var form = document.getElementById("produto-form");
        var divs = form.getElementsByTagName("div");
        for(var i=0; i<divs.length; i++){
            var classList = divs[i].classList;
            for(var j=0; j<classList.length; j++){
                if(classList[j] == "has-error"){
                    hasError = true;
                }
            }
        }
        if(!hasError){
            var colunaMensagemIncuidoSucesso = document.getElementById("produto-form:coluna-mensagen-incluido-sucesso");
            colunaMensagemIncuidoSucesso.classList.remove("invisible");
            colunaMensagemIncuidoSucesso.classList.add("visible");
        }
    }
});

String.prototype.reverse = function(){
    return this.split('').reverse().join('');
}

function mascaraMoeda(campo){
    var valor  =  campo.value.replace(/[^\d]+/gi,'').reverse();
    var resultado  = "";
    var mascara = "##.###.###,##".reverse();
    for (var x=0, y=0; x<mascara.length && y<valor.length;) {
        if (mascara.charAt(x) != '#') {
            resultado += mascara.charAt(x);
            x++;
        } else {
            resultado += valor.charAt(y);
            y++;
            x++;
        }
    }
    campo.value = resultado.reverse();
}

function preSubmit(){
    var validar = document.getElementById("validar").value;
    if(validar === "true" || validar === true){
        var form = document.getElementById("produto-form");
        var formChildElements = form.getElementsByTagName("input");
        for(var i=0; i<formChildElements.length; i++){
            var childNode = formChildElements[i];
            if(childNode.type == "text"){
                var id = childNode.id;
                if(id.indexOf("-required") !== -1){
                    if(childNode.value == ""){
                        alert("É NECESSÁRIO PREENCHER TODOS OS CAMPOS OBRIGATÓRIOS, CUJA DESCRIÇÃO TEM PREFIXO '*'");
                        return true;
                    }
                }
            }
        }
        formataPreco();
    }
    return true;
}

function formataPreco() {
    var preco = document.getElementsByName("input_produto-form:preco-required")[0].value;
    var precoFormatado = preco.replace(",",".").replace(".","");
    document.getElementsByName("input_produto-form:preco-required")[0].value = precoFormatado;

    return true;
}

function limpaTela(){
    var form = document.getElementById("produto-form");
    var formChildElements = form.getElementsByTagName("input");
    for(var i=0; i<formChildElements.length; i++) {
        var childNode = formChildElements[i];
        if (childNode.type == "text") {
            childNode.value = "";
        }
    }
}

function acionaBotaoListar(){
    document.getElementById("validar").value = false;
    var botaoListar = document.getElementById("produto-form:listar");
    botaoListar.click();
}

function acionaBotaoCadastrar(){
    var botaoCadastrar = document.getElementById("produto-form:cadastrar");
    botaoCadastrar.click();
}
