object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sum = Value
}

import WeekDay._

def isWorkingDay(d: WeekDay) = !(d == Sat || d == Sum)

WeekDay.values filter isWorkingDay foreach println