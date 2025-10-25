package com.lisboa42.projects.calculator_app.calculator

import com.lisboa42.projects.calculator_app.common.Log


fun calculateExpression(expression: String): String {
    if (expression.isBlank()) return "0"

    return try {
        val tokens = tokenize(expression)
        val rpn = infixToRPN(tokens)
        val result = evaluateRPN(rpn)
        result.toString()
    } catch (e: Exception) {
        Log.d("calculateExpression", e.toString())
        "Error"
    }
}

private fun tokenize(expression: String): List<String> {
    val tokens = mutableListOf<String>()
    var i = 0
    while (i < expression.length) {
        val c = expression[i]
        when {
            c.isDigit() || c == '.' -> {
                val start = i
                while (i + 1 < expression.length && (expression[i + 1].isDigit() || expression[i + 1] == '.')) i++
                tokens.add(expression.substring(start..i))
            }
            c in "+-*/" -> {
                if (c == '-' && (i == 0 || expression[i - 1] in "+-*/")) {
                    val start = i
                    i++
                    while (i < expression.length && (expression[i].isDigit() || expression[i] == '.')) i++
                    tokens.add(expression.substring(start until i))
                    i--
                } else {
                    tokens.add(c.toString())
                }
            }
        }
        i++
    }
    return tokens
}

private fun infixToRPN(tokens: List<String>): List<String> {
    val output = mutableListOf<String>()
    val operators = ArrayDeque<String>()

    val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)

    for (token in tokens) {
        when {
            token.toDoubleOrNull() != null -> output.add(token)
            token in precedence -> {
                while (operators.isNotEmpty() && (precedence[operators.lastOrNull()] ?: 0) >= precedence[token]!!) {
                    output.add(operators.removeLast())
                }
                operators.addLast(token)
            }
        }
    }

    while (operators.isNotEmpty()) output.add(operators.removeLast())
    return output
}

private fun evaluateRPN(tokens: List<String>): Double {
    val stack = ArrayDeque<Double>()

    for (token in tokens) {
        val number = token.toDoubleOrNull()
        if (number != null) {
            stack.addLast(number)
        } else {
            val b = stack.removeLast()
            val a = stack.removeLast()
            val result = when (token) {
                "+" -> a + b
                "-" -> a - b
                "*" -> a * b
                "/" -> a / b
                else -> throw IllegalArgumentException("Unknown operator: $token")
            }
            stack.addLast(result)
        }
    }

    return stack.removeLast()
}