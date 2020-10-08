package ru.pdn.sfedu.operationshistory.model

import java.math.BigDecimal
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
class Operation (
        @field:XmlElement(name = "fromAccount")
        val fromAccount: String? = null,
        @field:XmlElement(name = "toAccount")
        val toAccount: String? = null,
        @field:XmlElement(name = "amount")
        val amount: BigDecimal? = null,
        @field:XmlElement(name = "currency")
        val currency: String? = null,
        @field:XmlElement(name = "date")
        val date: String? = null,
        @field:XmlElement(name = "id")
        val id: Long? = null


) {
        override fun toString(): String {
                return "Operation(amount=$amount, date=$date)"
        }
}