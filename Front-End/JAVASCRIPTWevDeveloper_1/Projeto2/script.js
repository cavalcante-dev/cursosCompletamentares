
function adicionarTarefa() {
    
    let mensagemPos = "Tarefa adicionada com sucesso!";
    let mensagemNeg = "O campo está vazio!";

    let addTarefa = document.getElementById("addTarefa");
    let tarefa = addTarefa.value;
    

    if (!tarefa) {

        document.getElementById("mensagem").textContent = mensagemNeg;
        
    } else {

        document.getElementById("mensagem").textContent = mensagemPos;

        let listaTarefas = document.getElementById("listaTarefas");
        let novaTarefa = document.createElement("li");

        novaTarefa.textContent = tarefa;

        listaTarefas.appendChild(novaTarefa);

    }

    addTarefa.value = "";

}