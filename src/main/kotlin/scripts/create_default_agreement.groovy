package scripts

import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info("Creating default agreement for purchaseOrder: $relation_purchase_order_id, Process: $process_id - started")

def body = new DefaultAgreementBody()

if (execution.getVariable("service_category") == "ZITEL_FIBER") 
    
{body.description = "سرویس اینترنت Zitel Fiber  " }


//relation_purchase_order_id=44998012-08de-49a0-97f8-80bfe70f0652
//relation_customer=32297c50-1738-4a28-a4f8-9e51b6ea3efe
def agreement = remoteService.callByMe("POST", "http://bss-service/api/agreements/default?order=$relation_purchase_order_id&customer=$relation_customer", body)

def agreementId = agreement.id
execution.setVariable('relation_agreement', agreementId)

def agreementItemId = agreement.agreementItemList[0].id
execution.setVariable('agreementItemId', agreementItemId)


class DefaultAgreementBody {
    def description = new String()
}