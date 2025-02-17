public interface ItemAcervo {

    void exibirDetalhes();

    String getTitulo();

    default ItemAcervo buscar(String titulo) {
        if(this.getTitulo().equalsIgnoreCase(titulo)) {
            return this;
        } else {
            return null;
        }
    }
}
