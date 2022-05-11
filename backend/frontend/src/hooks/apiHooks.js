import axios from "axios";

export const fetchDocument = async (documentId) => {
    var documentFromServer
    await axios.get("http://localhost:8080/documents/" + documentId).then((response) => {
        documentFromServer = response.data;
      }
    );
    return documentFromServer;
}

export const fetchDocuments = async () => {
    var documentsFromServer;
    await axios.get("http://localhost:8080/documents").then((response) => {
        documentsFromServer = response.data
    }); 
    return documentsFromServer;
}

export const fetchDocumentsWithCriteria = async (criteria) => {
    var documentsFromServer;
    await axios.post("http://localhost:8080/documents/search",criteria).then((response) => {
        documentsFromServer = response.data
        console.log(documentsFromServer);
    }); 
    return documentsFromServer;
}