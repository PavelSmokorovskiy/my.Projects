package my.projects;

import my.projects.Games.Console.BattleShip.ConsoleGameBattleShip;
import my.projects.Games.Gui.TicTacToe.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame { //Класс главного окна

    JRadioButton game1RadioButton = new JRadioButton("Морской бой в консольном окне");              //Переключатель "Морской бой в консольном окне"
    JRadioButton game2RadioButton = new JRadioButton("Крестики нолики в консольном окне");          //Переключатель "Крестики нолики в консольном окне"
    JRadioButton game3RadioButton = new JRadioButton("Крестики нолики с графическим интерфейсом");  //Переключатель "Крестики нолики с графическим интерфейсом"
    JRadioButton game4RadioButton = new JRadioButton("Шахматы");                                    //Переключатель "Шахматы"
    JRadioButton game5RadioButton = new JRadioButton("Угадай число в консольном окне");             //Переключатель "Угадай число в консольном окне"

    private MainWindow() throws HeadlessException {   //Конструктор главного фрейма. Не знаю, что такое throws HeadlessException
        super();    //
        setTitle("Мои проекты");  //Заголовок
        setSize(new Dimension(390, 300));  //Размер окна
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Дейстие по нажатию кнопки "Закрыть"
        setLocationRelativeTo(null);    //Окно по центру
        ImageIcon icon = new ImageIcon("src/myprojects/Resources/WindowIcon.png"); //Файл оконной иконки
        setIconImage(icon.getImage());  //замена иконки окна вместо кофейной чашки
        addPanelButton(getContentPane());  //Метод добавляет панель кнопок Ok и Cancel
        addTabbedPane(getContentPane()); //Метод добавляет панель вкладок
        setVisible(true);   //Окно видимое
    }        //Главное окно

    private void addPanelButton(Container contentPane){ //Метод сбора компонентов панели кнопок
        JPanel panelButton = new JPanel();              //Панель кнопок
        contentPane.add(panelButton, BorderLayout.SOUTH);   //Закрепление панели в нижней части окна
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); //Менеджер размещения кнопок по центру панели с отступами
        JButton buttonOk = new JButton("     Ok     "); //Кнопка ОК
        JButton buttonCancel = new JButton("Cancel");   //Кнопка Cancel
        panelButton.add(buttonOk);      //Добавление кнопки Ок на панель кнопок
        panelButton.add(buttonCancel);  //Добавление кнопки Cancel на панель кнопок
        buttonOk.addActionListener(new ActionButtonOk());           //Слушатель по нажатию на Ok
        buttonCancel.addActionListener(new ActionButtonCancel());   //Слушатель по нажатию на Cancel
    }   //Панель кнопок. Метод сбора компонентов.

    private void addTabbedPane(Container contentPane) { //Метод сбора компонентов панели вкладок
        JTabbedPane tabbedPane = new JTabbedPane(); //Панель вкладок
        JPanel gamePanel = new JPanel();    //Панель "Игры"
        JPanel programPanel = new JPanel(); //Панель "Программы"
        JPanel worksPanel = new JPanel();   //Панель "Работы"
        JPanel draftPanel = new JPanel();   //Панель "Черновики"
        JPanel contactPanel = new JPanel(); //Панель "Контакты"
        JLabel gameLabel = new JLabel();    //Метка панели "Игры"
        JLabel programLabel = new JLabel(); //Метка панели "Программы"
        JLabel worksLabel = new JLabel();   //Метка панели "Работы"
        JLabel draftLabel = new JLabel();   //Метка панели "Черновики"
        JLabel contactLabel = new JLabel(); //Метка панели "Контакты"
        contentPane.add(gamePanel);         //Панель "Игры"
        contentPane.add(programPanel);      //Панель "Программы"
        contentPane.add(worksPanel);        //Панель "Работы"
        contentPane.add(draftPanel);        //Панель "Черновики"
        contentPane.add(contactPanel);      //Панель "Контакты"
        gamePanel.add(gameLabel);           //Метка панели "Игры"
        programPanel.add(programLabel);     //Метка панели "Программы"
        worksPanel.add(worksLabel);         //Метка панели "Работы"
        draftPanel.add(draftLabel);         //Метка панели "Черновики"
        contactPanel.add(contactLabel);     //Метка панели "Контакты"
        tabbedPane.add("Игры", gamePanel);          //Название вкладки "Игры"
        tabbedPane.add("Программы", programPanel);  //Название вкладки "Программы"
        tabbedPane.add("Работы", worksPanel);       //Название вкладки "Работы"
        tabbedPane.add("Черновики", draftPanel);    //Название вкладки "Черновики"
        tabbedPane.add("Контакты", contactPanel);   //Название вкладки "Контакты"
        gamePanel.add(game1RadioButton);     //Переключатель "Морской бой в консольном окне"
        gamePanel.add(game2RadioButton);     //Переключатель "Крестики нолики в консольном окне"
        gamePanel.add(game3RadioButton);     //Переключатель "Крестики нолики с графическим интерфейсом"
        gamePanel.add(game4RadioButton);     //Переключатель "Шахматы"
        gamePanel.add(game5RadioButton);     //Переключатель "Угадай число в консольном окне"
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.PAGE_AXIS)); //Менеджер размещения переключателей
        gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0)); //Установление отступов
        contentPane.add(tabbedPane);        //Добавление панели вкладок к параметрам метода
    }   //Панель вкладок. Метод сбора компонентов.

    private class ActionButtonOk implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            if (game1RadioButton.isSelected()) {
                dispose();
                ConsoleGameBattleShip.main();
            } else if (game2RadioButton.isSelected()) {
                JOptionPane.showMessageDialog(null, "Не работает", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
//                dispose();
//                TicTacToe.main();
            } else if (game3RadioButton.isSelected()) {
                new TicTacToe();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Неверный выбор");
            }
        }
    }

    private class ActionButtonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }      //Не знаю как это писать


    public static void main (String []args){
        new MainWindow();





    }

}
