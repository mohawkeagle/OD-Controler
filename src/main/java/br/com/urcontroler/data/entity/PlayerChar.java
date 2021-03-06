package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Collection;
import java.util.Objects;

/**
 * Entidade dos personagens de jogadores
 *
 * @author kaciano
 */
public class PlayerChar {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Jogador")
    private String player;
    @ColumnName(name = "Idade")
    private Integer age;
    @ColumnName(name = "Sexo")
    private Character sex;
    @ColumnName(name = "Altura")
    private Double height;
    @ColumnName(name = "Peso")
    private Integer weight;
    @ColumnName(name = "Classe")
    private ClassBase charClass;
    @ColumnName(name = "Raça")
    private Race charRace;
    @Ignore
    @ColumnName(name = "Informações")
    private Collection<PlayerCharInfo> playerCharInfoCollection;
    @Ignore
    @ColumnName(name = "Pericias")
    private Collection<Expertise> expertiseCollection;

    /**
     * Cria nova instancia de PlayerChar
     */
    public PlayerChar() {
    }

    /**
     * Cria nova instancia de PlayerChar
     *
     * @param id {@code Long} Id do personagem
     * @param charName {@code String} Nome do personagem
     * @param playerName {@code String} Nome do jogador
     * @param age {@code Integer} Idade do personagem
     * @param sex {@code Character} Sexo do personagem
     * @param height {@code Double} Altura do personagem
     * @param weight {@code Integer} Peso do personagem
     * @param charClass {@code ClassBase} Classe do personagem
     * @param charRace {@code Race} Raça do personagem
     */
    public PlayerChar(Long id, String charName, String playerName, Integer age, Character sex, Double height, Integer weight, ClassBase charClass, Race charRace) {
        this.id = id;
        this.name = charName;
        this.player = playerName;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Retorna o Id do personagem
     *
     * @return {@code Long} Id do personagem
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do personagem
     *
     * @param id {@code Long} Id do personagem
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do personagem
     *
     * @return {@code String} Nome do personagem
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do personagem
     *
     * @param name {@code String} Nome do personagem
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Nome do jogador
     *
     * @return {@code String} Nome do jogador
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Modifica o Nome do jogador
     *
     * @param player {@code String} Nome do jogador
     */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
     * Retorna a Idade do personagem
     *
     * @return {@code Integer} Idade do personagem
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Modifica a Idade do personagem
     *
     * @param age {@code Integer} Idade do personagem
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Retorna o Sexo do personagem
     *
     * @return {@code Character} Sexo do personagem
     */
    public Character getSex() {
        return sex;
    }

    /**
     * Modifica o Sexo do personagem
     *
     * @param sex {@code Character} Sexo do personagem
     */
    public void setSex(Character sex) {
        this.sex = sex;
    }

    /**
     * Retorna a Altura do personagem
     *
     * @return {@code Double} Altura do personagem
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Modifica a Altura do personagem
     *
     * @param height {@code Double} Altura do personagem
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Retorna o Peso do personagem
     *
     * @return {@code Integer} Peso do personagem
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Modifica o Peso do personagem
     *
     * @param weight {@code Integer} Peso do personagem
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Retorna os Infos do personagem
     *
     * @return {@code Collection(PlayerCharInfo)} Infos do personagem
     */
    public Collection<PlayerCharInfo> getPlayerCharInfoCollection() {
        return playerCharInfoCollection;
    }

    /**
     * Modifica os Infos do personagem
     *
     * @param playerCharInfoCollection {@code Collection(PlayerCharInfo)} Infos
     * do personagem
     */
    public void setPlayerCharInfoCollection(Collection<PlayerCharInfo> playerCharInfoCollection) {
        this.playerCharInfoCollection = playerCharInfoCollection;
    }

    /**
     * Retorna a Classe do personagem
     *
     * @return {@code ClassBase} Classe do personagem
     */
    public ClassBase getCharClass() {
        return charClass;
    }

    /**
     * Modifica a Classe do personagem
     *
     * @param charClass {@code ClassBase} Classe do personagem
     */
    public void setCharClass(ClassBase charClass) {
        this.charClass = charClass;
    }

    /**
     * Retorna a Raça do personagem
     *
     * @return {@code ClassBase} Raça do personagem
     */
    public Race getCharRace() {
        return charRace;
    }

    /**
     * Modifica a Raça do personagem
     *
     * @param charRace {@code ClassBase} Raça do personagem
     */
    public void setCharRace(Race charRace) {
        this.charRace = charRace;
    }

    /**
     * Retorna as Perícias do personagem
     *
     * @return {@code Collection(Expertise)} Perícias do personagem
     */
    public Collection<Expertise> getExpertiseCollection() {
        return expertiseCollection;
    }

    /**
     * Modifica as Perícias do personagem
     *
     * @param expertiseCollection {@code Collection(Expertise)} Perícias do
     * personagem
     */
    public void setExpertiseCollection(Collection<Expertise> expertiseCollection) {
        this.expertiseCollection = expertiseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerChar other = (PlayerChar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
