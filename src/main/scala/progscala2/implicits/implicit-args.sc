// 永远不要用Float标示货币
def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

object SimpleStateSalesTax {
    implicit val rate: Float = 0.05F
}

case class ComplicatedSalesTaxData (
    baseRate: Float,
    isTaxHoliday: Boolean,
    storeId: Int
)

object ComplicatedSalesTax {
    private def extraTaxRateForStore(id: Int): Float = {
        // 通过ID推断商铺所在地, 之后在计算附加税
        0.00F
    }

    implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float =
        if (cstd.isTaxHoliday) 0.00F
        else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
}

{
    import SimpleStateSalesTax.rate

    val amount = 100F
    println(s"Tax on $amount = ${calcTax(amount)}")
}

{
    import ComplicatedSalesTax.rate

    implicit val myStroe = ComplicatedSalesTaxData(0.06F, false, 1010)

    val amount = 100F
    println(s"Tax on $amount = ${calcTax(amount)}")
}