import java.io.File

fun main() {
    val file = File("out/test.txt")
    val filename = "$file" // имя файла для чтения
    val numbers = mutableListOf<Int>() // массив для хранения чисел
    var currentNumber = ""
    var isNegative = false
    var graf = 0

    File(filename).forEachLine { line ->
        for (char in line) {
            when(graf)
            {
                0 -> {
                    println("я сейчас в $graf графе и следующий символ '$char'")
                    if (char.isDigit()) {
                        currentNumber += char
                    } else if (currentNumber.isNotEmpty()) {
                        val number = currentNumber.toInt()
                        if (isNegative) {
                            numbers.add(-number)
                            isNegative = false
                        } else {
                            numbers.add(number)
                        }
                        currentNumber = ""
                        graf = 2
                    }
                    if (char.toInt() in 32..44 || char.toInt() in 46..47 || char.toInt() in 58..126 ){
                        graf = 1
                    }
                    if (char == '-') {
                        isNegative = true
                        graf = 3
                    } else if (char == '#') {
                        graf = 4
                        break // прекращаем чтение строки при встрече символа "#"
                    }
                }
                1 -> {
                    println("я сейчас в $graf графе и следующий символ '$char'")
                    if (char.isDigit()) {
                        currentNumber += char
                    } else if (currentNumber.isNotEmpty()) {
                        val number = currentNumber.toInt()
                        if (isNegative) {
                            numbers.add(-number)
                            isNegative = false
                        } else {
                            numbers.add(number)
                        }
                        currentNumber = ""
                        graf = 0
                    }
                    if (char.toInt() in 32..44 || char.toInt() in 46..47 || char.toInt() in 58..126 ){
                        graf = 3
                    }
                    if (char == '-') {
                        isNegative = true
                        graf = 2
                    } else if (char == '#') {
                        graf = 4
                        break // прекращаем чтение строки при встрече символа "#"
                    }
                }
                2 -> {
                    println("я сейчас в $graf графе и следующий символ '$char'")
                    if (char.isDigit()) {
                        currentNumber += char
                    } else if (currentNumber.isNotEmpty()) {
                        val number = currentNumber.toInt()
                        if (isNegative) {
                            numbers.add(-number)
                            isNegative = false
                        } else {
                            numbers.add(number)
                        }
                        currentNumber = ""
                        graf = 1
                    }
                    if (char.toInt() in 32..44 || char.toInt() in 46..47 || char.toInt() in 58..126 ){
                        graf = 0
                    }
                    if (char == '-') {
                        isNegative = true
                        graf = 3
                    } else if (char == '#') {
                        graf = 4
                        break // прекращаем чтение строки при встрече символа "#"
                    }
                }
                3 -> {
                    println("я сейчас в $graf графе и следующий символ '$char'")
                    if (char.isDigit()) {
                        currentNumber += char
                    } else if (currentNumber.isNotEmpty()) {
                        val number = currentNumber.toInt()
                        if (isNegative) {
                            numbers.add(-number)
                            isNegative = false
                        } else {
                            numbers.add(number)
                        }
                        currentNumber = ""
                        graf = 0
                    }
                    if (char.toInt() in 32..44 || char.toInt() in 46..47 || char.toInt() in 58..126 ){
                        graf = 2
                    }
                    if (char == '-') {
                        isNegative = true
                        graf = 1
                    } else if (char == '#') {
                        graf = 4
                        break // прекращаем чтение строки при встрече символа "#"
                    }
                }
                4 -> {
                    break
                }
            }
        }
    }

    println("Числа, найденные в файле:")
    println(numbers)
}
