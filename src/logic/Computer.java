package logic;

/**
 * Created by Yulia on 05.11.2016.
 */

import java.util.ArrayList;
import java.util.Random;

// ���������-���������
public class Computer {

    public FieldShip field;
    public int x, y;
    Random rand;

     //�������� ������ ��� ���������� ����

    public Computer(FieldShip field) {
        this.field = field;
        this.rand = new Random();
    }


    //������� ������� �������

    public boolean tryShot() {
        ArrayList<Element> list = new ArrayList<Element>();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Element e = field.elements[i][j];
                if (!e.shuted) {
                    list.add(e);
                }
            }
        }
        Element e = list.get(rand.nextInt(list.size()));
        return field.doShot(e.x, e.y);
    }

    // ������� ���

    public boolean move() {
        boolean finded = false;
        // ���� �������� ������� �������
        first: for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Element element = field.elements[i][j];
                if (element.state == ElementStates.Injured) {
                    // ����� �������� ������� �������
                    finded = true;
                    x = i;
                    y = j;
                    break first;
                }
            }
        }

        return tryShot();
    }

    // �������� ���������� X

    public int getX() {
        return this.x;
    }

    // �������� ���������� Y

    public int getY() {
        return this.y;
    }

}

