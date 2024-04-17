
class SearchService {
    fetchData(currentGrid) {
        return fetch('http://localhost:8080/pathfinder/path', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ grid: currentGrid }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .catch(error => console.error('Error:', error));
    }
}