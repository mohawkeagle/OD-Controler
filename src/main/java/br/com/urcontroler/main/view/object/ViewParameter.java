package br.com.urcontroler.main.view.object;

/**
 * Parametro para carregamento de views
 *
 * @author Kaciano Ghelere
 */
public class ViewParameter {

    private Boolean canSave;
    private Boolean canProcess;
    private Boolean canClear;
    private Boolean canLoad;

    /**
     * Cria nova instancia de ViewParameter
     */
    public ViewParameter() {
    }

    /**
     * Cria nova instancia de ViewParameter
     *
     * @param save {@code boolean} Pode salvar?
     * @param process {@code boolean} Pode processar?
     * @param clear {@code boolean} Pode limpar?
     * @param load {@code boolean} Pode carregar?
     */
    public ViewParameter(boolean save, boolean process, boolean clear, boolean load) {
        this.canSave = save;
        this.canProcess = process;
        this.canClear = clear;
        this.canLoad = load;
    }

    @Override
    public String toString() {
        return "\n"
                + "Pode salvar: " + canSave + ",\n"
                + "Pode processar: " + canProcess + ",\n"
                + "Pode limpar: " + canClear + ",\n"
                + "Pode carregar: " + canLoad + "\n";
    }

    /**
     * Retorna se pode salvar
     *
     * @return {@code boolean} Pode salvar?
     */
    public Boolean isSave() {
        return canSave;
    }

    /**
     * Modifica se pode salvar
     *
     * @param canSave {@code boolean} Pode salvar?
     */
    public void setSave(Boolean canSave) {
        this.canSave = canSave;
    }

    /**
     * Retorna se pode processar
     *
     * @return {@code boolean} Pode processar?
     */
    public Boolean isProcess() {
        return canProcess;
    }

    /**
     * Modifica se pode processar
     *
     * @param canProcess {@code boolean} Pode processar?
     */
    public void setProcess(Boolean canProcess) {
        this.canProcess = canProcess;
    }

    /**
     * Retorna se pode limpar
     *
     * @return {@code boolean} Pode limpar?
     */
    public Boolean isClear() {
        return canClear;
    }

    /**
     * Modifica se pode limpar
     *
     * @param canClear {@code boolean} Pode limpar?
     */
    public void setClear(Boolean canClear) {
        this.canClear = canClear;
    }

    /**
     * Retorna se pode carregar
     *
     * @return {@code boolean} Pode carregar?
     */
    public Boolean isLoad() {
        return canLoad;
    }

    /**
     * Modifica se pode carregar
     *
     * @param canLoad {@code boolean} Pode carregar?
     */
    public void setLoad(Boolean canLoad) {
        this.canLoad = canLoad;
    }

}
