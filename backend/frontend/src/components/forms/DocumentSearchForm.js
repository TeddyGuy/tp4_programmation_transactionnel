import { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { fetchDocumentsWithCriteria } from '../../hooks/apiHooks';

const DocumentSearchForm = () => {
    const initialFormData = {
        title:'',
        author:'',
        genre:'',
        publicationYear:0
    }

    const[formData, setFormData] = useState(initialFormData);

    const formHandler = async (e) => {
        e.preventDefault();
        var documents = await fetchDocumentsWithCriteria(formData);
        console.log(documents);
    }

    return(
        <>
            <Form className='m-auto mb-3 border border-warning rounded p-3' noValidate style={{ width: '32rem' }} onSubmit={formHandler}>
                <h1 className='text-center'>Recherche de documents</h1>
                <Form.Group className='mb-3' controlId='title'>
                    <Form.Label>Titre</Form.Label>
                    <Form.Control
                     value={formData.title} 
                     onChange={(e) => setFormData({...formData, 'title': e.target.value}) } type="text" placeholder='Harry Potter'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='author'>
                    <Form.Label>Auteur</Form.Label>
                    <Form.Control  
                    value={formData.author} 
                    onChange={(e) => setFormData({...formData, 'author': e.target.value}) }
                    type="text" placeholder='J.K Rowlings'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='genre'>
                    <Form.Label>Genre</Form.Label>
                    <Form.Control 
                    value={formData.genre}  
                    onChange={(e) => setFormData({...formData, 'genre': e.target.value}) }
                    type="text" placeholder='Fantaisie'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='publicationYear'>
                    <Form.Label>Année de publication</Form.Label>
                    <Form.Control
                    value={formData.publicationYear}  
                    onChange={(e) => setFormData({...formData, 'publicationYear': e.target.value}) }
                    type="number"/>
                </Form.Group>
                <div className='text-center'>
                    <Button variant="success" type='submit'>Rechercher</Button> : 
                </div> 
            </Form>
        </>
    );
}

export default DocumentSearchForm;