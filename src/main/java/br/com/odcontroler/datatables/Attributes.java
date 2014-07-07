package br.com.odcontroler.datatables;

import br.com.gmp.utils.collections.Pair;
import br.com.odcontroler.data.entity.attr.Attribute;
import br.com.odcontroler.datatables.charisma.CharData;
import br.com.odcontroler.datatables.charisma.CharValues;
import br.com.odcontroler.datatables.constitution.ConstData;
import br.com.odcontroler.datatables.constitution.ConstValues;
import br.com.odcontroler.datatables.dexterity.DexData;
import br.com.odcontroler.datatables.dexterity.DexValues;
import br.com.odcontroler.datatables.intelligence.IntelData;
import br.com.odcontroler.datatables.intelligence.IntelValues;
import br.com.odcontroler.datatables.strength.StrengthData;
import br.com.odcontroler.datatables.strength.StrengthValues;
import br.com.odcontroler.datatables.wisdom.WisdomData;
import br.com.odcontroler.datatables.wisdom.WisdomValues;
import java.util.List;

/**
 * Atributos e os demais ajustes
 *
 * @author kaciano
 * @version 1.0
 */
public interface Attributes {

    /**
     * Valores do atributo força
     */
    public static Pair<Attribute, List<StrengthData>> STR = new Pair<>(Attribute.STR, new StrengthValues().getValues());

    /**
     * Valores do atributo inteligencia
     */
    public static Pair<Attribute, List<IntelData>> INT = new Pair<>(Attribute.INT, new IntelValues().getValues());

    /**
     * Valores do atributo sabedoria
     */
    public static Pair<Attribute, List<WisdomData>> WIS = new Pair<>(Attribute.WIS, new WisdomValues().getValues());

    /**
     * Valores do atributo destreza
     */
    public static Pair<Attribute, List<DexData>> DEX = new Pair<>(Attribute.DEX, new DexValues().getValues());

    /**
     * Valores do atributo constituição
     */
    public static Pair<Attribute, List<ConstData>> CONS = new Pair<>(Attribute.CONS, new ConstValues().getValues());

    /**
     * Valores do atributo carisma
     */
    public static Pair<Attribute, List<CharData>> CHAR = new Pair<>(Attribute.CHAR, new CharValues().getValues());

}
