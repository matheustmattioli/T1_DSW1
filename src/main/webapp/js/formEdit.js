function requestUsuarioEdit(context, usuario) {
    window.location.assign("/" + context + "/admin/edicao?tipo=usuario&id=" + usuario);
}

function requestAgenciaEdit(context, agencia) {
    window.location.assign("/" + context + "/admin/edicao?tipo=agencia&id=" + agencia);
}