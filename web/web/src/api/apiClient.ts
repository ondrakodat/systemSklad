
const API_URL = "http://localhost:8080/api/";

//export - muze se pouzit v jinem souboru
// async - asynchroni operace
// <T> genericka funkce
// url : String - parametr
// Funkce nevrati vysledek okamzite, ale vrati promise ktere pozdeji bude obsahovat T
export async function apiGet<T>(url: string): Promise <T> {
    const response = await fetch(`${API_URL}${url}`);

    if(!response.ok){
        throw new Error(`HTTP error: ${response.status}`);
    }

    return response.json();
}

/*
* Post metoda
* TRequest -
* TResponse
* data : TRequest
 */
export async function apiPost <TRequest, TResponse> (
    url : String,
    data : TRequest
) : Promise <TResponse> {
    const response = await fetch(`${API_URL}${url}`,
        {
            method: "Post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });
    if(!response.ok){
        throw new Error(`HTTP error: ${response.status}`);
    }
    return response.json();
}