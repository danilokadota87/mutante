package com.br.org.mutantes.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantesService {

    public Boolean isMutante(List<String> adn) {
        if (checkHorizontal(adn)) return true;

        if (checkVertical(adn)) return true;

        if (checkObliquanteASC(adn)) return true;

        return checkObliquanteDESC(adn);
    }

    private boolean checkVertical(List<String> adn) {
        for (int i = 0; i < adn.size(); i++) {
            char[] charArray = adn.get(i).toCharArray();
            for (int ic = 0; ic < charArray.length; ic++) {
                try {
                    String columDown = adn.get(i + 1);
                    char[] array = columDown.toCharArray();
                    if (charArray[ic] == array[ic]) {
                        String columDown2 = adn.get(i + 2);
                        char[] array2 = columDown2.toCharArray();
                        if (array[ic] == array2[ic]) {
                            String columDown3 = adn.get(i + 3);
                            char[] array3 = columDown3.toCharArray();
                            if (array2[ic] == array3[ic]) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(List<String> adn) {
        for (String colum : adn) {
            Character cc = 'z';
            int count = 0;
            for (Character c : colum.toCharArray()) {
                if (c.equals(cc)) {
                    count = count + 1;
                    cc = c;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                    cc = c;
                }
            }
        }
        return false;
    }

    private boolean checkObliquanteDESC(List<String> adn) {
        for (int i = 0; i < adn.size(); i++) {
            char[] charArray = adn.get(i).toCharArray();
            for (int ic = 0; ic < charArray.length; ic++) {
                try {
                    String columDown = adn.get(i + 1);
                    char[] array = columDown.toCharArray();
                    if (charArray[ic] == array[ic - 1]) {
                        String columDown2 = adn.get(i + 2);
                        char[] array2 = columDown2.toCharArray();
                        if (array[ic - 1] == array2[ic - 2]) {
                            String columDown3 = adn.get(i + 3);
                            char[] array3 = columDown3.toCharArray();
                            if (array2[ic - 2] == array3[ic - 3]) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    private boolean checkObliquanteASC(List<String> adn) {
        for (int i = 0; i < adn.size(); i++) {
            char[] charArray = adn.get(i).toCharArray();
            for (int ic = 0; ic < charArray.length; ic++) {
                try {
                    String columDown = adn.get(i + 1);
                    char[] array = columDown.toCharArray();
                    if (charArray[ic] == array[ic + 1]) {
                        String columDown2 = adn.get(i + 2);
                        char[] array2 = columDown2.toCharArray();
                        if (array[ic + 1] == array2[ic + 2]) {
                            String columDown3 = adn.get(i + 3);
                            char[] array3 = columDown3.toCharArray();
                            if (array2[ic + 2] == array3[ic + 3]) {
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
