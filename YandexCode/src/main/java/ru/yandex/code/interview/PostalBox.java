package ru.yandex.code.interview;

import java.util.ArrayList;

/**
 * Постамат - автоматическая станция приёма/выдачи посылок.
 * В маркете формируются заказы, и хочется добавить возможность получения через постамат.
 * Запускаем MVP: небольшая аудитория пользователей, несколько постаматов в Москве.
 * При заказе пользователь сможет выбрать, что хочет получить заказ в постамате.
 *
 * В рамках задачи нужно реализовать код для MVP решения:
 * - курьер привозит заказ и пробует положить его в ячейку, указывая номер заказа. Постамат сам выбирает ячейку и возвращает в ответ. Она откроется вызывающим этот метод кодом.
 * - после того, как заказ положили в ячейку, пользователю отправляется СМС c кодом получения. Заказ будет ждать вечно
 * - в случае любых ошибок - курьер забирает заказ назад и попробует положить заказ в ячейку на следующий день (для MVP это ок)
 * - пользователь может получить заказ по коду выдачи из СМС. При вводе кода выдачи постамат должен вывести на экран текст "ваш заказ ХХХ в ячейке YYY", ячейка откроется сама.
 *
 * Ограничения:
 * - все ячейки одного размера, но их может быть разное количество, зависит от конкретного постамата
 * - один заказ - одна коробка, она влезает в ячейку
 * - ячейки каждого постамата пронумерованы
 * - каждый постамат сам хранит своё состояние
 *
 * Для отправки сообщения пользователю надо использовать клиент UserNotificationApi.
 */
class PostalBox {

    public static final int NO_CELL = -1;
    private static final int NO_ORDER = -1;
    private static Cell NONE_CELL = new Cell(NO_CELL);

    private final UserNotificationApi notificationApi;

    // нужно реализовать методы хранения и выдачи заказа
    private final ArrayList<Cell> cells;

    public PostalBox(int mvpCapacity) {
        cells = new ArrayList<>(mvpCapacity);
        for(int i=0; i<mvpCapacity; i++){
            cells.add(new Cell(i)); // cellNumber == array index
        }
    }

    private Cell getEmptyCell(){
        for(Cell cell: cells){
            if( !cell.isEmpty() ){
                return cell;
            }
        }
        return NONE_CELL;
    }

    public int putOrder(int orderNumber){
        Cell cell = getEmptyCell();
        if( cell.isEmpty() ){
            int smsCode = notificationApi.sendSMS(orderNumber, cell.getCellNumber());
            cell.putOrder(orderNumber, smsCode);
        }
        return cell.getCellNumber();
    }

    public String getOrder(int smsCode){
        int orderNumber = NO_ORDER, cellNumber = NO_CELL;
        for(Cell cell: cells){
            if( cell.getSmsCode() == smsCode ){
                cellNumber = cell.getCellNumber(); // TODO:
                orderNumber = cell.getOrder();
                break;
            }
        }
        return String.format("ваш заказ %d в ячейке %d", orderNumber, cellNumber);
    }

    public static class Cell {

        private static final int EMPTY_CELL = -1;
        private static final int NO_SMS_CODE = -1;

        private final int cellNumber;
        private int orderNumber;
        private int smsCode;

        public Cell(int cellNumber) {
            this.cellNumber = cellNumber;
            this.orderNumber = EMPTY_CELL;
        }

        public int getOrderNumber() {
            return orderNumber;
        }

        public int getCellNumber() {
            return cellNumber;
        }

        public int getSmsCode() {
            return smsCode;
        }

        public boolean isEmpty() {
            return orderNumber == EMPTY_CELL;
        }
        public void putOrder(int orderNumber, int smsCode) {
            this.orderNumber = orderNumber;
            this.smsCode = smsCode;
        }

        public int getOrder() {
            int order = orderNumber;
            this.orderNumber = EMPTY_CELL;
            this.smsCode = NO_SMS_CODE;
            return  order;
        }
    }
}


/**
 * Синхронный клиент, вызывающий postalbox.notify.market.yandex.net
 * Реализацию интерфейса описывать не нужно.
 */
interface UserNotificationApi {
    // нужно описать метод(ы) для отправки сообщения с кодом выдачи
    // в ответ придёт код выдачи, который был отправлен пользователю
    public int sendSMS(int orderNumber, int cellNumber);

}

