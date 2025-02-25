<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum Calculator</title>
    <script>
        function calculateSum() {
            // Get the input values
            var number1 = parseFloat(document.getElementById("number1").value);
            var number2 = parseFloat(document.getElementById("number2").value);
            // Calculate the sum
            var sum = number1 + number2;
            // Display the sum
            document.getElementById("result").innerText = "Sum: " + sum;
        }
    </script>
</head>
<body>
    <h2>Sum Calculator</h2>
    <form onsubmit="event.preventDefault(); calculateSum();">
        <label for="number1">Number 1:</label>
        <input type="number" id="number1" name="number1" required /><br/><br/>
        
        <label for="number2">Number 2:</label>
        <input type="number" id="number2" name="number2" required /><br/><br/>
        
        <button type="submit">Calculate Sum</button>
    </form>
    
    <h3 id="result"></h3> <!-- This will display the result -->
</body>
</html>  