import java.util.ArrayList
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import java.util.logging.Logger
Logger logger = Logger.getLogger("")

execution.setVariable("customer_id",relation_customer)

class ProductList {
    String id
    Integer itemCount
}

class Body {
    List < ProductList > productList = new ArrayList <ProductList> ();
    String timeInterval
    String provinceCity
    String postalCode
    String geoLocation
    String address
    String description
}



   
    Body body = new Body()



    if (execution.getVariable("form_ptp_required_asset_double") != null || execution.getVariable("form_ptp_required_asset_single") != null) {

        if (execution.getVariable("form_ptp_required_asset_double") != null) {
            form_ptp_required_asset_double.each {
                e ->
                    ProductList productList = new ProductList()
                productList.id = e.toString()
                productList.itemCount = 2
                body.productList.add(productList);
            }
        }

        if (execution.getVariable("form_ptp_required_asset_single") != null) {
            form_ptp_required_asset_single.each {
                e ->
                    ProductList productList = new ProductList()
                productList.id = e.toString()
                productList.itemCount = 1
                body.productList.add(productList);
            }
        }
    }

    body.timeInterval = "12-MONTH"
   // body.timeInterval = serviceInterval.toString();
    body.provinceCity = form_order_province_city
    body.postalCode = orderPostalCode
    body.geoLocation = form_tech_gps_point
    body.address = orderAddress
    body.description = ""


    logger.info("> > >  BODY:: " + new JsonBuilder(body).toString())
    
// creating new contract and new agreement

    def contract = remoteService.callByMe("POST", "http://bss-service/api/contracts/full?customer=$relation_customer", body)

    logger.info("> > >  contract:: " + new JsonBuilder(contract).toString())


//----------------------------------------

execution.setVariable('agreement_id', contract.agreementList[0].id)
execution.setVariable('relation_agreement', contract.agreementList[0].id)
