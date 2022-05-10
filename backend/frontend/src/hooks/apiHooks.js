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