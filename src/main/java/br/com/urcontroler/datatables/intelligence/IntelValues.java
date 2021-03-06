package br.com.urcontroler.datatables.intelligence;

import br.com.urcontroler.data.entity.AttrRange;
import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Inteligencia
 *
 * @author kaciano
 * @version 1.0
 */
public class IntelValues {

    private final List<IntelData> intValues;

    /**
     * Cria nova instancia de IntValues
     */
    public IntelValues() {
        this.intValues = new ArrayList<>();
        intValues.add(new IntelData(new AttrRange("0-1"), 0, 0));
        intValues.add(new IntelData(new AttrRange("2-3"), 0, 0));
        intValues.add(new IntelData(new AttrRange("4-5"), 0, 0));
        intValues.add(new IntelData(new AttrRange("6-7"), 0, 0));
        intValues.add(new IntelData(new AttrRange("8-9"), 0, 0));
        intValues.add(new IntelData(new AttrRange("10-11"), 0, 0));
        intValues.add(new IntelData(new AttrRange("12-13"), 0, 0));
        intValues.add(new IntelData(new AttrRange("14-15"), 1, 25));
        intValues.add(new IntelData(new AttrRange("16-17"), 2, 35));
        intValues.add(new IntelData(new AttrRange("18-19"), 3, 45));
        intValues.add(new IntelData(new AttrRange("20-21"), 4, 55));
        intValues.add(new IntelData(new AttrRange("22-23"), 5, 65));
        intValues.add(new IntelData(new AttrRange("24-25"), 6, 75));
        intValues.add(new IntelData(new AttrRange("26-27"), 7, 85));
        intValues.add(new IntelData(new AttrRange("28-29"), 8, 95));
        intValues.add(new IntelData(new AttrRange("30-31"), 8, 95));
        intValues.add(new IntelData(new AttrRange("32-33"), 8, 95));
        intValues.add(new IntelData(new AttrRange("34-35"), 8, 95));
        intValues.add(new IntelData(new AttrRange("36-37"), 8, 95));
        intValues.add(new IntelData(new AttrRange("38-39"), 8, 95));
        intValues.add(new IntelData(new AttrRange("40-41"), 8, 95));
        intValues.add(new IntelData(new AttrRange("42-43"), 8, 95));
        intValues.add(new IntelData(new AttrRange("44-45"), 8, 95));
        intValues.add(new IntelData(new AttrRange("46-47"), 8, 95));
        intValues.add(new IntelData(new AttrRange("48-49"), 8, 95));
    }

    /**
     * Retorna a lista de valores para inteligencia
     *
     * @return {@code List(IntData)} Lista de valores para inteligencia
     */
    public List<IntelData> getValues() {
        return intValues;
    }
}
