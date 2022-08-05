function requestUsuarioEdit(context, usuario) {
    window.location.assign("/" + context + "/admin/edicao?tipo=usuario&id=" + usuario);
}

function requestUsuarioDelete(context, usuario) {
    window.location.assign("/" + context + "/admin/deletar?tipo=usuario&id=" + usuario);
}

function requestAgenciaEdit(context, agencia) {
    window.location.assign("/" + context + "/admin/edicao?tipo=agencia&id=" + agencia);
}

function requestAgenciaDelete(context, agencia) {
    window.location.assign("/" + context + "/admin/deletar?tipo=agencia&id=" + agencia);
}

function requestRemovePacoteUsuario(context, idPacote) {
    window.location.assign("/" + context + "/usuario/deletar?id=" + idPacote);
}

function requestPacoteDelete(context, idPacote) {
    window.location.assign("/" + context + "/agencia/deletar?id=" + idPacote);
}

function requestPacoteEdit(context, idPacote) {
    window.location.assign("/" + context + "/agencia/edicao?id=" + idPacote);
}