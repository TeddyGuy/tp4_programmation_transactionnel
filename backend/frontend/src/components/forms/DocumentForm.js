import { Form, Button } from 'react-bootstrap';
import { emptyDocumentData } from "../../model/Document";

const DocumentForm = ({formHandler, formData, setFormData}) => {

    const clearForm = () => {
        setFormData(emptyDocumentData)
    } 

    return(
        <>
        <Form className='m-auto mb-3 border border-warning rounded p-3' noValidate style={{ width: '32rem' }} onSubmit={formHandler}>
                <h1 className='text-center'>Créer/Modifier un document</h1>
                <Form.Group className='d-none' controlId='id'>
                    <Form.Label>ID</Form.Label>
                    <Form.Control value={formData.id} type="text" disabled readOnly/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='type'>
                    <Form.Label>Type</Form.Label>
                    <Form.Select
                    isInvalid={formData.type === "default"}
                    disabled={!(formData.id === '')}
                    value={formData.type} 
                    onChange={(e) => setFormData({...formData, 'type': e.target.value}) }>
                        <option hidden value="default">Choisissez un type de document</option>
                        <option value="book">Livre</option>
                        <option value="cd">CD</option>
                        <option value="cd">DVD</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group className='mb-3' controlId='title'>
                    <Form.Label>Titre</Form.Label>
                    <Form.Control
                     required
                     value={formData.title} 
                     onChange={(e) => setFormData({...formData, 'title': e.target.value}) } type="text" placeholder='Harry Potter'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='author'>
                    <Form.Label>Auteur</Form.Label>
                    <Form.Control  
                    required
                    value={formData.author} 
                    onChange={(e) => setFormData({...formData, 'author': e.target.value}) }
                    type="text" placeholder='J.K Rowlings'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='genre'>
                    <Form.Label>Genre</Form.Label>
                    <Form.Control 
                    required
                    value={formData.genre}  
                    onChange={(e) => setFormData({...formData, 'genre': e.target.value}) }
                    type="text" placeholder='Fantaisie'/>
                </Form.Group>
                {
                    formData.type === 'book' && 
                    <Form.Group className='mb-3' controlId='publisher'>
                        <Form.Label>Maison d'édition</Form.Label>
                        <Form.Control 
                            required
                            value={formData.publisher}  
                            onChange={(e) => setFormData({...formData, 'publisher': e.target.value}) }
                            type="text" placeholder='Édition Boréal'/>
                        </Form.Group>
                }
                <Form.Group className='mb-3' controlId='publicationYear'>
                    <Form.Label>Année de publication</Form.Label>
                    <Form.Control 
                    required
                    value={formData.publicationYear}  
                    onChange={(e) => setFormData({...formData, 'publicationYear': e.target.value}) }
                    type="number"/>
                </Form.Group>
                {
                    formData.type === 'book' && 
                    <Form.Group className='mb-3' controlId='pages'>
                        <Form.Label>Nombre de pages</Form.Label>
                        <Form.Control 
                            required
                            value={formData.pages}  
                            onChange={(e) => setFormData({...formData, 'pages': e.target.value}) }
                            type="text"/>
                        </Form.Group>
                }
                <Form.Group className='mb-3' controlId='copies'>
                    <Form.Label>Nombre d'exemplaires</Form.Label>
                    <Form.Control 
                    required
                    value={formData.copies}  
                    disabled={formData.id === ''}
                    onChange={(e) => setFormData({...formData, 'copies': e.target.value}) }
                    type="number"/>
                </Form.Group>
                <div className='text-center'>
                    {formData.id === '' ? 
                    <Button variant="success" type='submit'>Confirmer</Button> : 
                    <Button className="me-2" variant="success" type='submit'>Modifier</Button> }
                    
                    {!(formData.id === '') && <Button variant="info" onClick={clearForm}>Créer</Button>}
                </div> 
            </Form>
        </>
    );
}

export default DocumentForm;