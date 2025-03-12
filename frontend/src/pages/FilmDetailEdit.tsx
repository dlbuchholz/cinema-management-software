import React, { useEffect, useState } from 'react';
import { Form, Input, Button, Typography, message, List, Modal } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import filmService from '../services/cinemaService';
import { Movie, ScreeningData } from '../types';
const { Title } = Typography;

const FilmDetailEdit: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [film, setFilm] = useState<Movie | null>(null);
  const [screenings, setScreenings] = useState<ScreeningData[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [isScreeningModalVisible, setIsScreeningModalVisible] = useState<boolean>(false);

  useEffect(() => {
    if (id) {
      filmService.getMovieById(id).then(data => {
        setFilm(data);
        setLoading(false);
      });
      filmService.getScreeningsByMovieId(id).then(data => setScreenings(data));
    }
  }, [id]);

  const onFinish = (values: Movie) => {
    if (film) {
      const updatedFilm: Movie = { ...film, ...values };
      filmService.updateFilm(updatedFilm).then(() => {
        message.success('Film updated successfully');
        setFilm(updatedFilm);
      }).catch(() => {
        message.error('Update failed');
      });
    }
  };

  const softDeleteFilm = () => {
    if (film) {
      filmService.deleteMovie(film.id).then(() => {
        message.success('Film soft-deleted');
        navigate('/account/film');
      }).catch(() => {
        message.error('Soft delete failed');
      });
    }
  };

  const showScreeningModal = () => {
    setIsScreeningModalVisible(true);
  };

  const handleScreeningModalCancel = () => {
    setIsScreeningModalVisible(false);
  };

  if (loading || !film) {
    return <div>Loading...</div>;
  }

  return (
    <div style={{ padding: '40px 20px', width: '50%', margin: 'auto' }}>
      <Title level={3}>Film Details - {film.title}</Title>
      <Form
        layout="vertical"
        initialValues={{ title: film.title, description: film.description }}
        onFinish={onFinish}
      >
        <Form.Item label="Title" name="title" rules={[{ required: true, message: 'Please input the title!' }]}>
          <Input />
        </Form.Item>
        <Form.Item label="Description" name="description">
          <Input.TextArea rows={4} />
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit">Update Film</Button>
          <Button type="default" danger onClick={softDeleteFilm} style={{ marginLeft: 10 }}>
            Soft Delete Film
          </Button>
        </Form.Item>
      </Form>
      <Title level={4}>Screenings</Title>
      <Button type="primary" onClick={showScreeningModal} style={{ marginBottom: 10 }}>
        Create Screening
      </Button>
      <List
        dataSource={screenings}
        renderItem={(screening) => (
          <List.Item
            actions={[
              <Button size="small" onClick={() => {/* implement edit screening */}}>Edit</Button>,
              <Button size="small" danger onClick={() => {
                filmService.deleteScreening(screening.id).then(() => {
                  message.success('Screening deleted');
                  filmService.getScreeningsByFilmId(film.id).then(data => setScreenings(data));
                });
              }}>Delete</Button>
            ]}
          >
            <List.Item.Meta
              title={`Hall: ${screening.cinemaHall}`}
              description={`Starts: ${new Date(screening.startTime).toLocaleString()} | Seats: ${screening.availableSeats}`}
            />
          </List.Item>
        )}
      />
      <Modal
        title="Create Screening"
        visible={isScreeningModalVisible}
        onCancel={handleScreeningModalCancel}
        footer={null}
      >
        <Form
          layout="vertical"
          onFinish={(values) => {
            filmService.createScreening(film.id, values).then(() => {
              message.success('Screening created');
              filmService.getScreeningsByFilmId(film.id).then(data => setScreenings(data));
              setIsScreeningModalVisible(false);
            }).catch(() => {
              message.error('Creation failed');
            });
          }}
        >
          <Form.Item label="Cinema Hall" name="cinemaHall" rules={[{ required: true, message: 'Please enter hall name' }]}>
            <Input />
          </Form.Item>
          <Form.Item label="Start Time" name="startTime" rules={[{ required: true, message: 'Please enter start time' }]}>
            <Input placeholder="YYYY-MM-DD HH:mm" />
          </Form.Item>
          <Form.Item label="Available Seats" name="availableSeats" rules={[{ required: true, message: 'Please enter available seats' }]}>
            <Input type="number" />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">Create Screening</Button>
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
};

export default FilmDetailEdit;
