import { Col, Row, Spinner } from "react-bootstrap";
import axios from "axios";
import { useEffect, useState } from "react";
import DocumentCardList from "./DocumentCardList";
import DocumentForm from "./DocumentForm";

const useForceUpdate = () => {
    const [value, setValue] = useState(0); 
    const increment = () => setValue((prev) => prev + 1);
    return [increment, value];
}

const AdminPortal = () => {
    const initialFormData = {
        id:'',
        title:'',
        type:'default',
        author:'',
        genre:'',
        publisher:'',
        publicationYear:0,
        pages:0,
        copies:1
    }
    const[documents, setDocuments] = useState([]);
    const[formData, setFormData] = useState(initialFormData);
    const [forceUpdate, count] = useForceUpdate();

    useEffect(()=>{
        const getDocuments = async () => {
            const documentsFromServer = await fetchDocuments();
            setDocuments(documentsFromServer);
        }
        getDocuments();
    },[formData, count]);

    const fetchDocuments = async () => {
        var documentsFromServer;
        await axios.get("http://localhost:8080/documents").then((response) => {
            documentsFromServer = response.data
        }); 
        return documentsFromServer;
    }

    const formHandler = (e) => {
        e.preventDefault();
        const form = e.currentTarget;

        if(!(form.checkValidity() && !form.querySelector("#type").className.includes("is-invalid"))) return;

        if(formData.id === ''){
            createDocument();
        }
        else{
            updateDocument();
        }
    }

    const createDocument = async () => {
        await axios.post("http://localhost:8080/documents/" + formData.type + "s", formData);
        setFormData(initialFormData);
    }

    const updateDocument = async () => {
        await axios.patch("http://localhost:8080/documents/" + formData.type + "s/" + formData.id, formData);
        forceUpdate();
    }

    return(
    <>
        <Row className="py-5 px-5">
            <Col>
                {
                    documents.length > 0 ?
                    <DocumentCardList documents={documents} setFormData={setFormData}/> :
                    <Spinner className='m-auto' animation="border" variant="warning"/>
                }
            </Col>
            <Col>
                <DocumentForm formData={formData} setFormData={setFormData} formHandler={formHandler}/>
            </Col>
        </Row>
    </>
    );
}

export default AdminPortal;