package br.com.urcontroler.main.util;

import br.com.urcontroler.data.db.entity.Description;

/**
 * Classe utilitária para gerar descrições de telas
 *
 * @author Kaciano Ghelere
 */
public class DescriptionObject {

    private String title;
    private String description;
    private String commit;
    private String proccess;
    private String clear;
    private String load;
    private final String base = "<html>"
            + "<body style='margin: 10px'>"
            + "<b>%1$2s</b><br><br>"
            + "%2$2s<br><br>"
            + "Funções<br><br>"
            + "        <table border=\"1\">"
            + "            <thead>"
            + "                <tr>"
            + "                    <th>Função</th>"
            + "                    <th>Ação</th>"
            + "                </tr>"
            + "            </thead>"
            + "            <tbody>"
            + "                <tr>"
            + "                    <td><b>F2</b> - Salvar</td>"
            + "                    <td>%3$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F6</b> - Processar</td>"
            + "                    <td>%4$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F4</b> - Limpar</td>"
            + "                    <td>%5$2s</td>"
            + "                </tr>"
            + "                <tr>"
            + "                    <td><b>F8</b> - Carregar</td>"
            + "                    <td>%6$2s</td>"
            + "                </tr>"
            + "            </tbody>"
            + "        </table>"
            + "</body>"
            + "</html>";

    /**
     * Cria nova instancia de Description
     */
    private DescriptionObject() {
        this.title = "--";
        this.description = "--";
        this.commit = "--";
        this.proccess = "--";
        this.clear = "--";
        this.load = "--";
    }

    /**
     * Cria nova instancia de Description
     *
     * @param title {@code String} Texto do titulo
     * @param description {@code String} Texto da descrição
     * @param commit {@code String} Texto da função de salvar
     * @param proccess {@code String} Texto da função de processar
     * @param clear {@code String} Texto da função de limpar
     * @param load {@code String} Texto da função de carregar
     */
    private DescriptionObject(String title, String description, String commit, String proccess, String clear, String load) {
        this.title = title;
        this.description = description;
        this.commit = commit;
        this.proccess = proccess;
        this.clear = clear;
        this.load = load;
    }

    /**
     * Retorna a descrição formatada da view
     *
     * @return {@code String} Descrição formatada da view
     */
    public String format() {
        return String.format(base, title, description, commit, proccess, clear, load);
    }

    /**
     * Classe construtora
     */
    public static class Builder {

        private DescriptionObject description;

        /**
         * Cria nova instancia de builder
         */
        public Builder() {
            this.description = new DescriptionObject();
        }

        /**
         * Cria nova instancia de Builder
         *
         * @param title {@code String} Texto do titulo
         * @param description {@code String} Texto da descrição
         * @param save {@code String} Texto da função de salvar
         * @param procces {@code String} Texto da função de processar
         * @param clear {@code String} Texto da função de limpar
         * @param load {@code String} Texto da função de carregar
         */
        public Builder(String title, String description, String save, String procces, String clear, String load) {
            this.description = new DescriptionObject(title, description, save, procces, clear, load);
        }

        /**
         * Retorna a descrição construida
         *
         * @return {@code Description} Descrição construida
         */
        public DescriptionObject apply() {
            return this.description;
        }

        /**
         * Modifica o Texto do titulo
         *
         * @param title {@code String} Texto do titulo
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setTitle(String title) {
            this.description.setTitle(title);
            return this;
        }

        /**
         * Modifica o Texto da descrição
         *
         * @param description {@code String} Texto da descrição
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setDescription(String description) {
            this.description.setDescription(description);
            return this;
        }

        /**
         * Modifica o Texto da função de salvar
         *
         * @param save {@code String} Texto da função de salvar
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setSave(String save) {
            this.description.setSave(save);
            return this;
        }

        /**
         * Modifica o Texto da função de processar
         *
         * @param process {@code String} Texto da função de processar
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setProcess(String process) {
            this.description.setProcces(process);
            return this;
        }

        /**
         * Modifica o Texto da função de limpar
         *
         * @param clear {@code String} Texto da função de limpar
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setClear(String clear) {
            this.description.setClear(clear);
            return this;
        }

        /**
         * Modifica o Texto da função de carregar
         *
         * @param load {@code String} Texto da função de carregar
         * @return {@code Builder} Construtor de descrição
         */
        public Builder setLoad(String load) {
            this.description.setLoad(load);
            return this;
        }

        /**
         * Cria descrição a partir de texto
         *
         * @param desc {@code String } Texto da descrição
         * @return {@code DescriptionObject} Objeto de descrição
         */
        public DescriptionObject fromBase(Description desc) {
            return this.setTitle(desc.getTitle())
                    .setDescription(desc.getDescription())
                    .setSave(desc.getCommitAction())
                    .setClear(desc.getClearAction())
                    .setLoad(desc.getLoadAction())
                    .setProcess(desc.getProcessAction())
                    .apply();
        }
    }

    /**
     * Retorna o Texto do titulo
     *
     * @return {@code String} Texto do titulo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Texto do titulo
     *
     * @param title {@code String} Texto do titulo
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Retorna o Texto da descrição
     *
     * @return {@code String} Texto da descrição
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica o Texto da descrição
     *
     * @param description {@code String} Texto da descrição
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Retorna o Texto da função de salvar
     *
     * @return {@code String} Texto da função de salvar
     */
    public String getCommit() {
        return commit;
    }

    /**
     * Modifica o Texto da função de salvar
     *
     * @param save {@code String} Texto da função de salvar
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setSave(String save) {
        this.commit = save;
        return this;
    }

    /**
     * Retorna o Texto da função de processar
     *
     * @return {@code String} Texto da função de processar
     */
    public String getProccess() {
        return proccess;
    }

    /**
     * Modifica o Texto da função de processar
     *
     * @param procces {@code String} Texto da função de processar
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setProcces(String procces) {
        this.proccess = procces;
        return this;
    }

    /**
     * Retorna o Texto da função de limpar
     *
     * @return {@code String} Texto da função de limpar
     */
    public String getClear() {
        return clear;
    }

    /**
     * Modifica o Texto da função de limpar
     *
     * @param clear {@code String} Texto da função de limpar
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setClear(String clear) {
        this.clear = clear;
        return this;
    }

    /**
     * Retorna o Texto da função de carregar
     *
     * @return {@code String} Texto da função de carregar
     */
    public String getLoad() {
        return load;
    }

    /**
     * Modifica o Texto da função de carregar
     *
     * @param load {@code String} Texto da função de carregar
     * @return {@code Description} Construtor de descrição
     */
    private DescriptionObject setLoad(String load) {
        this.load = load;
        return this;
    }

}