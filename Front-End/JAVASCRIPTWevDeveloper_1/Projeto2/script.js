let tarefas = [];    
const mensagem = document.getElementById("mensagem");

function adicionarTarefa() {
    
    const addTarefa = document.getElementById("addTarefa");
    let tarefa = addTarefa.value.trim();

    const mensagemPos = "Tarefa adicionada com sucesso!";
    const mensagemNeg = "O campo está vazio!";

    if (!tarefa) {
        mensagem.textContent = mensagemNeg;
    } else {
        mensagem.textContent = mensagemPos;
        tarefas.push(tarefa);
        renderizarTarefas();
    }

    addTarefa.value = "";

}

function renderizarTarefas() {

    let listaTarefas = document.getElementById("listaTarefas");

    listaTarefas.innerHTML = "";

    if(tarefas.length > 0) {
        
        let botaoRemoverTudo = document.createElement("button");
        botaoRemoverTudo.className = "removerTodos";
        botaoRemoverTudo.textContent = "Limpar Lista"
        botaoRemoverTudo.onclick = () => limparTarefas();
        
        let container = document.getElementById("botoes");
        container.appendChild(botaoRemoverTudo);

    } 

    for(let i = 0; i < tarefas.length; i++) {

        let novaTarefa = document.createElement("li");
        novaTarefa.textContent = tarefas[i];
        
        let botaoRemover = document.createElement("button");
        botaoRemover.className = "remover";
        botaoRemover.textContent="X";
        botaoRemover.onclick = () => removerTarefa(i);

        let botaoEditar = document.createElement("button");
        botaoEditar.className = "editar";
        botaoEditar.textContent="Editar";
        botaoEditar.onclick = () => editarTarefa(i);

        novaTarefa.appendChild(botaoRemover);    
        novaTarefa.appendChild(botaoEditar);
        listaTarefas.appendChild(novaTarefa);

    }

}

function removerTarefa(i) {
    tarefas.splice(i, 1);
    mensagem.textContent = "Tarefa excluida com sucesso!"
    renderizarTarefas();
}

function editarTarefa(i) {
    let tarefaEditada = prompt('Edite a sua tarefa: ');
    if (tarefaEditada.trim() !== "") {
        tarefas[i] = tarefaEditada;
        mensagem.textContent = "Tarefa editada com sucesso!"
        renderizarTarefas();
    } else {
        tarefaEditada = prompt('Tarefa em branco!');
    }
}

function limparTarefas() {
    tarefas.length = 0;
    mensagem.textContent = "Lista limpa com sucesso!"
    renderizarTarefas();
}