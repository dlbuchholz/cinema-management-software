import React, { useState, useEffect } from 'react';
import { Input, Card, Row, Col, Typography } from 'antd';
import { useNavigate } from 'react-router-dom';
import filmService from '../services/cinemaService';
import { Movie } from '../types';
const { Title } = Typography;

const FilmEdit: React.FC = () => {
  const [films, setFilms] = useState<Movie[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const navigate = useNavigate();

  useEffect(() => {
    filmService.getAllMovies().then((data: Movie[]) => setFilms(data));
  }, []);

  const filteredFilms = films.filter(film =>
    film.title.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div style={{ padding: 20,  width: '100%' }}>
      <Title level={3}>Filme</Title>
      <Input.Search
        placeholder="Film suchen"
        onChange={(e) => setSearchTerm(e.target.value)}
        style={{ marginBottom: 20 }}
      />
      <Row gutter={[16, 16]}>
        {filteredFilms.map((film) => (
          <Col key={film.id} xs={24} sm={12} md={8} lg={6}>
            <Card
              hoverable
              onClick={() => navigate(`/account/film/${film.id}`)}
            >
              {film.title}
            </Card>
          </Col>
        ))}
      </Row>
    </div>
  );
};

export default FilmEdit;
