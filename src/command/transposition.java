package command;

import iterator.Container;
import iterator.Iterator;
import iterator.listStrIterator;
import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class transposition implements Container {

    openWords ow = new openWords();
    List<String> words = ow.openwords();

    public List tp(JTextArea text) {
        ow.openwords();
        boolean sonuc;
        String txt = text.getText();
        List<String> hatalilar = new ArrayList<>();

        int uzn = txt.length();
        for (int i = 0; i < uzn; i++) {
            sonuc = false;
            if (isLetter(txt.charAt(i))) {
                int firsti = i;
                while (isLetter(txt.charAt(i))) {
                    i++;
                    if (i == uzn) {
                        break;
                    }
                }
                int lasti = i;
                String kelime = txt.substring(firsti, lasti);
                Iterator iter = getIterator();

                while (iter.hasNext()) {
                    if (iter.next().toString().equalsIgnoreCase(kelime)) {
                        sonuc = true;
                    }
                }

                if (!sonuc) {
                    int kuzn = kelime.length();
                    for (int j = 0; j < kuzn - 1; j++) {
                        char ilk = kelime.charAt(j);
                        char ikinci = kelime.charAt(j + 1);
                        String newk = kelime.substring(0, j) + ikinci + ilk + kelime.substring(j + 2, kuzn);

                        Iterator iter1 = getIterator();
                        while (iter1.hasNext()) {

                            if (newk.equalsIgnoreCase(iter1.next().toString())) {
                                kelime = newk;
                                txt = txt.substring(0, firsti) + kelime + txt.substring(lasti, uzn);
                                sonuc = true;
                            }
                        }

                    }
                }

                if (!sonuc) {
                    hatalilar.add(kelime);
                }
                i = i - 1;
            }

        }
        text.setText(txt);
        return hatalilar;

    }

    @Override
    public Iterator getIterator() {
        return new listStrIterator(words);
    }

}
