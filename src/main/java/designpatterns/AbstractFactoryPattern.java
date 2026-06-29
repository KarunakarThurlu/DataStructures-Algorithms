package designpatterns;


/**
 * ================================================================
 * Abstract Factory Pattern
 * ================================================================
 *
 * Intent:
 * Creates a family of related objects without specifying their
 * concrete classes.
 *
 * In this example:
 *
 * India Logistics Factory
 *      -> Indian Truck
 *      -> Indian Invoice
 *
 * USA Logistics Factory
 *      -> USA Train
 *      -> USA Invoice
 *
 * Unlike Factory Pattern (creates ONE object),
 * Abstract Factory creates MULTIPLE RELATED OBJECTS.
 * ================================================================
 */


/*==========================================================
                    PRODUCT - 1
==========================================================*/

/**
 * Common interface for all transportation services.
 */
interface TransportService {

    /**
     * Dispatch goods.
     *
     * @param goods Goods to dispatch.
     * @return Dispatch message.
     */
    String dispatch(String goods);
}


/*==========================================================
                    PRODUCT - 2
==========================================================*/

/**
 * Common interface for invoice generation.
 */
interface InvoiceService {

    /**
     * Generate invoice.
     *
     * @param goods Goods for invoice.
     * @return Invoice details.
     */
    String generateInvoice(String goods);
}


/*==========================================================
                INDIA PRODUCT FAMILY
==========================================================*/

/**
 * Concrete Product
 */
class IndianTruck implements TransportService {

    @Override
    public String dispatch(String goods) {
        return "Dispatching " + goods + " using Indian Truck";
    }
}

/**
 * Concrete Product
 */
class IndianBus implements TransportService {

    @Override
    public String dispatch(String goods) {
        return "Dispatching " + goods + " using Indian Bus";
    }
}

/**
 * Concrete Product
 */
class IndianInvoice implements InvoiceService {

    @Override
    public String generateInvoice(String goods) {
        return "GST Invoice generated for " + goods;
    }
}


/*==========================================================
                USA PRODUCT FAMILY
==========================================================*/

/**
 * Concrete Product
 */
class USATruck implements TransportService {

    @Override
    public String dispatch(String goods) {
        return "Dispatching " + goods + " using USA Truck";
    }
}

/**
 * Concrete Product
 */
class USATrain implements TransportService {

    @Override
    public String dispatch(String goods) {
        return "Dispatching " + goods + " using USA Train";
    }
}

/**
 * Concrete Product
 */
class USAInvoice implements InvoiceService {

    @Override
    public String generateInvoice(String goods) {
        return "Sales Tax Invoice generated for " + goods;
    }
}


/*==========================================================
                ABSTRACT FACTORY
==========================================================*/

/**
 * Abstract Factory
 *
 * Responsible for creating a family of related objects.
 */
interface LogisticsFactory {

    /**
     * Creates Transport object.
     */
    TransportService createTransport();

    /**
     * Creates Invoice object.
     */
    InvoiceService createInvoice();
}


/*==========================================================
            CONCRETE FACTORY - INDIA
==========================================================*/

/**
 * Creates Indian-specific products.
 */
class IndiaLogisticsFactory implements LogisticsFactory {

    @Override
    public TransportService createTransport() {

        // Can return IndianBus() if business requirement changes.
        return new IndianTruck();
    }

    @Override
    public InvoiceService createInvoice() {

        return new IndianInvoice();
    }
}


/*==========================================================
            CONCRETE FACTORY - USA
==========================================================*/

/**
 * Creates USA-specific products.
 */
class USALogisticsFactory implements LogisticsFactory {

    @Override
    public TransportService createTransport() {

        return new USATrain();
    }

    @Override
    public InvoiceService createInvoice() {

        return new USAInvoice();
    }
}


/*==========================================================
                    CLIENT
==========================================================*/

public class AbstractFactoryPattern {

    public static void main(String[] args) {

        String goods = "Books";

        /*
         * Client requests India factory.
         * Client doesn't know which concrete classes are created.
         */
        LogisticsFactory factory = new IndiaLogisticsFactory();

        TransportService transport = factory.createTransport();
        InvoiceService invoice = factory.createInvoice();

        System.out.println("========== INDIA ==========");
        System.out.println(transport.dispatch(goods));
        System.out.println(invoice.generateInvoice(goods));

        System.out.println();

        /*
         * Switch factory.
         * Client code remains unchanged.
         */
        factory = new USALogisticsFactory();

        transport = factory.createTransport();
        invoice = factory.createInvoice();

        System.out.println("========== USA ==========");
        System.out.println(transport.dispatch(goods));
        System.out.println(invoice.generateInvoice(goods));
    }
}