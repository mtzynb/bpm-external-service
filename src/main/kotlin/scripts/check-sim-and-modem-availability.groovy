//check IMEI & SIM & change lead status
// Task ID: Task_1wf4xdw

class Characteristic{
    String selectedValue
    String selectedValueLabel
    String key
    String keyLabel
    String characteristicId
    String monolingual
    String sortOrder
}

//println "enter script check IMEI availability"

if (execution.getVariable("form_equipment_device_imei_1") != null){

    def productOffer = remoteService.call("GET", "http://bss-service/api/product-offerings/"+'48d5fed8-8337-46df-929b-f0ff1acdfdef')

    def productOfferId = productOffer.id

    //println "productOfferId: ${productOfferId}"

    Characteristic characteristic = new Characteristic()

    def data = new ArrayList<>()

    characteristic.selectedValue = execution.getVariable("form_equipment_device_imei_1")
    characteristic.selectedValueLabel = execution.getVariable("form_equipment_device_imei_1")
    characteristic.key = "imei"
    characteristic.keyLabel = "IMEI"

    productOffer.product.characteristicList.each { ch ->
        if(ch.key.equalsIgnoreCase("imei"))
            characteristic.characteristicId = ch.id
    }

    characteristic.monolingual = "true"
    characteristic.sortOrder = "0"

    data.add(characteristic)

    if(last_user != 1){
        form_installer_user_id = last_user}

    def employee = remoteService.call("GET", "http://bss-service/api/employees/find-by-user?user-id=$form_installer_user_id")

    def employeeId = employee.id

    def res = remoteService.callByMe("POST", "http://bss-service/api/warehouses/check-employee-stock?channel=mobile_app&offering-id=$productOfferId&employee-id=$employeeId", data)

    if (res != null)
        execution.setVariable('imei_validation',res)
    else
        execution.setVariable('imei_validation',false)

    //println "employeeId: ${employee.user.username} - imei_validation: ${imei_validation}"
}

//println "enter script check SIM availability"

if (execution.getVariable("form_equipment_sim_serial_1") != null){

    def productOffer = remoteService.call("GET", "http://bss-service/api/product-offerings/"+'a85bc3d3-38a8-42e1-86b7-e8879ad1af14')

    def productOfferId = productOffer.id

    //println "productOfferId: ${productOfferId}"

    Characteristic characteristic = new Characteristic()

    def data = new ArrayList<>()

    characteristic.selectedValue = execution.getVariable("form_equipment_sim_serial_1")
    characteristic.selectedValueLabel = execution.getVariable("form_equipment_sim_serial_1")
    characteristic.key = "serial_number"
    characteristic.keyLabel = "شماره سریال"

    productOffer.product.characteristicList.each { ch ->
        if(ch.key.equalsIgnoreCase("serial_number"))
            characteristic.characteristicId = ch.id
    }

    characteristic.monolingual = "true"
    characteristic.sortOrder = "0"

    data.add(characteristic)

    if(last_user != 1){
        form_installer_user_id = last_user
    }

    def employee = remoteService.call("GET", "http://bss-service/api/employees/find-by-user?user-id=$form_installer_user_id")

    def employeeId = employee.id

    def res = remoteService.callByMe("POST", "http://bss-service/api/warehouses/check-employee-stock?channel=mobile_app&offering-id=$productOfferId&employee-id=$employeeId", data)

    if (res != null)
        execution.setVariable('simcard_validation',res)
    else
        execution.setVariable('simcard_validation',false)

    //println "employeeId: ${employee.user.username} - simcard_validation: ${simcard_validation}"
}

//println "Change the last status of : ${relation_lead}"

remoteService.call("POST", "http://bss-service/api/leads/"+relation_lead+"/confirm")