import React, { useEffect, useState } from 'react';
import { Form, Input, Button, Typography, message } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import cinemaHallService from '../services/cinemaService';
import { CinemaHall } from '../types';
const { Title } = Typography;

const CinemaHallDetailEdit: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [hall, setHall] = useState<CinemaHall | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    if (id) {
      cinemaHallService.getHallById(id).then(data => {
        setHall(data);
        setLoading(false);
      });
    }
  }, [id]);

  const onFinish = (values: CinemaHall) => {
    if (hall) {
      const updatedHall: CinemaHall = { ...hall, ...values };
      cinemaHallService.updateHall(updatedHall).then(() => {
        message.success('Hall updated successfully');
        setHall(updatedHall);
      }).catch(() => {
        message.error('Update failed');
      });
    }
  };

  if (loading || !hall) {
    return <div>Loading...</div>;
  }

  return (
    <div style={{ padding: 20 }}>
      <Title level={3}>Filmsaal Details - {hall.name}</Title>
      <Form
        layout="vertical"
        initialValues={{ name: hall.name, totalSeats: hall.totalSeats, rows: hall.rows }}
        onFinish={onFinish}
      >
        <Form.Item label="Name" name="name" rules={[{ required: true, message: 'Please input hall name!' }]}>
          <Input />
        </Form.Item>
        <Form.Item label="Total Seats" name="totalSeats" rules={[{ required: true, message: 'Please input total seats!' }]}>
          <Input type="number" />
        </Form.Item>
        <Form.Item label="Rows" name="rows" rules={[{ required: true, message: 'Please input number of rows!' }]}>
          <Input type="number" />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit">Update Hall</Button>
        </Form.Item>
      </Form>
      <Button type="default" style={{ marginTop: 20 }} onClick={() => navigate('/account/saal')}>
        Back to Hall List
      </Button>
    </div>
  );
};

export default CinemaHallDetailEdit;
