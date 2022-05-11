import { Col, Row, Spinner } from "react-bootstrap";
import axios from "axios";
import { useEffect, useState } from "react";
import DocumentCardList from "../components/DocumentCardList";
import DocumentForm from "../components/forms/DocumentForm";
import useForceUpdate from "../hooks/useForceUpdate";
import { fetchDocuments } from "../hooks/apiHooks";
import DocumentSearchForm from "../components/forms/DocumentSearchForm";

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
    const [update, forceUpdate] = useForceUpdate();

    useEffect(()=>{
        const getDocuments = async () => {
            const documentsFromServer = await fetchDocuments();
            setDocuments(documentsFromServer);
        }
        getDocuments();
    },[formData, update]);

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
        <Row className="py-5 px-5 m-0">
            <Col>
                {
                    documents.length > 0 ?
                    <DocumentCardList documents={documents} setFormData={setFormData} mode={'edit'}/> :
                    <Spinner className='m-auto' animation="border" variant="warning"/>
                }
            </Col>
            <Col>
                <DocumentSearchForm/>
                <DocumentForm formData={formData} setFormData={setFormData} formHandler={formHandler}/>
            </Col>
        </Row>
    </>
    );
}

export default AdminPortal;