// Function to fetch string value from backend
async function fetchStringValue() {
    try {
        const response = await fetch('/string-value'); // Adjust the URL based on your backend endpoint
        const data = await response.text();
        document.getElementById('displayData').innerText = data; // Display the string value in a HTML element
    } catch (error) {
        console.error('Error fetching string value:', error);
    }
}

// Call the function to fetch and display data when the page loads
window.onload = fetchStringValue;