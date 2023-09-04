console.log('splicejs 실행');

var wavesurfer = WaveSurfer.create({ // WaveSurfer 오디오 파형 생성 함수 
    container: '#waveform',
    waveColor: '#D1D2D5', // 오디오 파형 색깔
    progressColor: 'blue', // 오디오파일 실행시켰을때 색깔
    //audioRate: 2,
    //splitChannels: true,
    //normalize: true,
});

wavesurfer.load('/jspweb/splice/sample/vox/PMND_Vocal_Chop_110BPM_03_Bm.wav');



playstop = () => {
  if(wavesurfer.isPlaying()){  // isPlaying 버튼을 눌렀을때 해당파일 실행시킴
     wavesurfer.pause(); // 실행시킨 이후에 버튼을 누르면 일시정지 됨
  }
  else{
    wavesurfer.play();
  }
};
