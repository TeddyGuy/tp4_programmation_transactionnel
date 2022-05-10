import { Form, Button } from 'react-bootstrap';

const ClientForm = ({formHandler, formData, setFormData}) => {
    const initialFormData = {
        id:'',
        firstName:'',
        lastName:'',
        email:'',
    }

    

    const clearForm = () => {
        setFormData(initialFormData)
    } 

    return(
        <>
            <Form className='m-auto border border-warning rounded p-3' style={{ width: '32rem' }} onSubmit={formHandler}>
                <h1 className='text-center'>Créer/Modifier un compte</h1>
                <Form.Group className='d-none' controlId='id'>
                    <Form.Label>ID</Form.Label>
                    <Form.Control value={formData.id} type="text" disabled readOnly/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='firstName'>
                    <Form.Label>Prénom</Form.Label>
                    <Form.Control
                     required
                     value={formData.firstName} 
                     onChange={(e) => setFormData({...formData, 'firstName': e.target.value}) } type="text" placeholder='René'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='lastName'>
                    <Form.Label>Nom</Form.Label>
                    <Form.Control  
                    required
                    value={formData.lastName} 
                    onChange={(e) => setFormData({...formData, 'lastName': e.target.value}) }
                    type="text" placeholder='Lévesque'/>
                </Form.Group>
                <Form.Group className='mb-3' controlId='email'>
                    <Form.Label>Email</Form.Label>
                    <Form.Control 
                    required
                    value={formData.email}  
                    onChange={(e) => setFormData({...formData, 'email': e.target.value}) }
                    type="email" placeholder='rene.lesvesque@example.com'/>
                </Form.Group>
                <div className='text-center'>
                    {formData.id === '' ? 
                    <Button variant="success" type='submit'>Confirmer</Button> : 
                    <Button className="me-2" variant="success" type='submit'>Modifier</Button> }
                    
                    {!(formData.id === '') && <Button variant="info" onClick={clearForm}>Créer</Button>}
                </div> 
            </Form>
        </>
    )
}

export default ClientForm;