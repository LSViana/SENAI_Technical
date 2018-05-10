package intro.api.senai.com.apiusage.models;

public class EstadoInfo {

    private String area_km2;
    private String codigo_ibge;
    private String nome;

    public EstadoInfo() {
        // Standard Constructor for JSON Parse
    }

    public EstadoInfo(String area_km2, String codigo_ibge, String nome) {
        this.area_km2 = area_km2;
        this.codigo_ibge = codigo_ibge;
        this.nome = nome;
    }

    public String getArea_km2() {
        return area_km2;
    }

    public void setArea_km2(String area_km2) {
        this.area_km2 = area_km2;
    }

    public String getCodigo_ibge() {
        return codigo_ibge;
    }

    public void setCodigo_ibge(String codigo_ibge) {
        this.codigo_ibge = codigo_ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "EstadoInfo{" +
                "area_km2='" + area_km2 + '\'' +
                ", codigo_ibge='" + codigo_ibge + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

}
