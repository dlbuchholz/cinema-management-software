// src/pages/CreateFilm.tsx

import React from 'react';
import { Form, Input, Button, Typography, message } from 'antd';
import { useNavigate } from 'react-router-dom';
import cinemaService from '../services/cinemaService';
import { Movie } from '../types';

const { Title } = Typography;

const CreateFilm: React.FC = () => {
  const [form] = Form.useForm();
  const navigate = useNavigate();

  const onFinish = async (values: Omit<Movie, 'id'>) => {
    try {
      await cinemaService.createMovie(values as Movie);
      message.success('Film created successfully');
      navigate('/account/film');
    } catch (error: any) {
      console.error('Error creating film:', error);
      message.error('Film creation failed');
    }
  };

  return (
    <div style={{ padding: '40px 20px', width: '50%', margin: 'auto' }}>
      <Title level={3} style={{ textAlign: 'center', marginBottom: '30px' }}>
        Create New Film
      </Title>
      <Form
        form={form}
        layout="vertical"
        onFinish={onFinish}
      >
        <Form.Item
          name="title"
          label="Title"
          rules={[{ required: true, message: 'Please enter the film title' }]}
        >
          <Input placeholder="Enter film title" />
        </Form.Item>
        <Form.Item
          name="description"
          label="Description"
          rules={[{ required: true, message: 'Please enter a description' }]}
        >
          <Input.TextArea placeholder="Enter film description" rows={4} />
        </Form.Item>
        <Form.Item
          name="length"
          label="Length (in minutes)"
          rules={[{ required: true, message: 'Please enter the film length' }]}
        >
          <Input type="number" placeholder="e.g. 120" />
        </Form.Item>
        <Form.Item
          name="genre"
          label="Genre"
          rules={[{ required: true, message: 'Please enter the film genre' }]}
        >
          <Input placeholder="e.g. Action, Drama, etc." />
        </Form.Item>
        <Form.Item name="posterUrl" label="Poster URL">
          <Input placeholder="Optional: URL for the film poster" />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit" block style={{ fontWeight: 600 }}>
            Create Film
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default CreateFilm;
